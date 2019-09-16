package com.bdqn.controller;

import com.bdqn.exception.BusinessExcpetion;
import com.bdqn.exception.EmBusinessError;
import com.bdqn.pojo.Role;
import com.bdqn.pojo.User;
import com.bdqn.pojo.viewOBject.UserVO;
import com.bdqn.response.CommonReturnType;
import com.bdqn.service.RoleService;
import com.bdqn.service.UserService;
import com.bdqn.utils.Page.PageResultBean;
import com.bdqn.utils.constant.Constants;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: UserController$
 * Description:用户控制器
 * Author: anyanglai
 * Date: 2019/9/3
 * Time: 15:01
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    /**
     * description: TODO  模型数据转成视图数据
     * create time: 2019/9/7 12:02
     * [user]
     *
     * @return com.bdqn.pojo.vo.UserVO
     */
    private UserVO convertFromModel(User user) {
//        处理空值的情况
        if (user == null) {
            return null;
        }
        UserVO userVO = new UserVO();
        //        copyProperties(Object source, Object target)；
        // 通过反射将一个对象的值赋值个另外一个对象（前提是对象中属性的名字相同）。
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }
    /**
     * @Description:
     * @Param: * @param
     * @Author: xqj
     * @Date:
     */
    @GetMapping("/userListJosn")
    @ResponseBody
    public CommonReturnType getUserList() throws BusinessExcpetion {
        List<User> userList = null;
        userList = userService.findUsers();
        if (userList.size() == 0) {
//            throw new BusinessExcpetion("数据获取失败!");
            throw new BusinessExcpetion(EmBusinessError.USER_NOT_EXIST);
        }
        //        将业务层的用户数据User转换成转化成控制器层的UserVO(需要通过java8lambda表达式)
        List<UserVO> userVOList1 = userList.stream().map(user ->{
            UserVO userVO =this.convertUserToVO(user);
            return  userVO;
        }).collect(Collectors.toList());
        return CommonReturnType.create(userList);
    }

    //获取用户信息，分页查询
    @GetMapping("/userList")
    public String userList(@RequestParam(value = "pageNum", required = false) String pageNum,
                           @RequestParam(value = "queryname", required = false) String queryname,
                           @RequestParam(value = "queryUserRole", required = false) Integer queryUserRole,
                           Model model) {

        if (pageNum == null) {
            pageNum = "1";
        }

        PageHelper.startPage(Integer.parseInt(pageNum), 5, "`u`.creationDate desc");
//        PageResultBean<User> userPageResultBean = new PageResultBean<User>(userService.findUsers());
        PageResultBean<User> userPageResultBean = new PageResultBean<User>(userService.selectUsersByRoleAndName(queryname, queryUserRole));
        List<User> userList = userPageResultBean.getRows();
        List<Role> roleList = roleService.findRoles();
        model.addAttribute("userList", userList);//分页的实体信息
        model.addAttribute("roleList", roleList);//分页的实体信息
        model.addAttribute("page", userPageResultBean);//分页信息
        model.addAttribute("pageNum", pageNum);//当前页
        return "user/userlist";
    }

    @GetMapping("useraddView")
    public String useraddView() {

        return "user/useradd";
    }


    /**
     * @Description: 通过userCode查询到信息
     * @Param:  * @param userCode
     * @return:
     * @Author: xqj
     * @Date:
     */
    @PostMapping("/getUserByCode")
    @ResponseBody
    public CommonReturnType getUserByCode(@RequestParam("userCode") String userCode) {
        User user = null;
        user = userService.findUserByCode(userCode);
        //将业务中的模型数据转化为视图领域中的模型数据
        UserVO userVO = this.convertUserToVO(user);
        if (userVO == null) {
            return CommonReturnType.create("notExist ", "fail");
        }
        return CommonReturnType.create(userVO);
    }

    /**
     * description: TODO  模型数据转成视图数据
     * create time: 2019/9/7 12:02
     * [user]
     *
     * @return com.bdqn.pojo.vo.UserVO
     */
    public CommonReturnType converUserToVo(User user){
        //处理空值
        if (user==null){
            return CommonReturnType.create("notExist ", "fail");
        }
        return CommonReturnType.create(user);
    }
    public UserVO convertUserToVO(User user){
        if (user==null){

        }
        UserVO userVO = new UserVO();
        //通过反射将一个对象的值赋值个另一个对象（前提是对象中的属性名字同名）
        BeanUtils.copyProperties(user, userVO);
        return userVO;
    }



    /**
     * description: TODO   新增用户的处理（包含用户图片的上传）
     * create time: 2019/9/8 20:32
     * [session, request, user, attachs]
     *
     * @return java.lang.String
     */
    @PostMapping(value = "doUseraddMulti")
    public String doUseraddMulti(HttpSession session,
                                 HttpServletRequest request,
                                 User user,
                                 @RequestParam(value = "attachs", required = false) MultipartFile[] attachs) throws IOException, BusinessExcpetion {

        String idPicPath = null;
        String workPicPath = null;
        String errorInfo = null;
        boolean flag1 = true;//是否上传
        user.setCreatedBy(((User) session.getAttribute(Constants.USERSESSION)).getId());
        user.setCreationDate(new Date());
//        获取上传文件到指定目录的路径
//        String path = request.getSession().getServletContext().getRealPath("statics" + File.separator + "uploadfiles");
        String path = "H:\\classworkspace\\springMyBatis\\src\\main\\webapp\\uploadfiles";
        for (int i = 0; i < attachs.length; i++) {
            MultipartFile attach = attachs[i];
            if (!attach.isEmpty()) {
                if (i == 0) {
                    errorInfo = "uploadFileError";
                } else if (i == 1) {
                    errorInfo = "uploadWpError";
                }
                String oldFileName = attach.getOriginalFilename();//原文件名
                String prefix = FilenameUtils.getExtension(oldFileName);//原文件后缀
                int filesize = 5000000;  //上传文件大小
                if (attach.getSize() > filesize) {
                    request.setAttribute(errorInfo, " * 上传大小不得超过 5M");
                    flag1 = false;
                } else if (prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png")
                        || prefix.equalsIgnoreCase("jpeg") || prefix.equalsIgnoreCase("pneg")) {//上传图片格式不正确
                    //重新命名
                    String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_Personal.jpg";
                    //目标目录
                    File targetFile = new File(path, fileName);
                    if (!targetFile.exists()) {
                        targetFile.mkdirs();
                    }
                    try {
                        //保存
                        attach.transferTo(targetFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                        request.setAttribute(errorInfo, " * 上传失败！");
                        flag1 = false;
                    }
                    if (i == 0) {  //证件照
                        idPicPath = path + File.separator + fileName;
                    } else if (i == 1) { //工作照
                        workPicPath = path + File.separator + fileName;
                    }
                } else {
                    request.setAttribute(errorInfo, " * 上传图片格式不正确");
                    flag1 = false;
                }
            }
        }
        if (flag1) {
            user.setIdPicPath(idPicPath);
            user.setWorkPicPath(workPicPath);
            //调用保存用户的业务
            if (userService.addUser1(user)) {
                return Constants.REDIRECT + "userList";//列表页
            } else {
                return Constants.REDIRECT + "user/useradd";//重新添加页面
            }
        }
        return Constants.REDIRECT + "user/useradd";//重新添加页面
    }


    /**
     * description: TODO
     * create time: 2019/9/8 20:32
     * [userId, model]
     *
     * @return java.lang.String
     */
    @GetMapping(value = "/viewUser/{userid}")
    public String viewUser(@PathVariable Integer userid ,Model model){
            //调取相应Model 业务逻辑数据
        User user = userService.findUserById1(userid);
        //        需要将UserModel转换成UserVO（供用户来查看的信息）
        UserVO userVO = convertFromModel(user);
        model.addAttribute("user", user);
        return "user/userView";
    }


    /**
     * description: TODO  跳转到用户修改页面（同时传入相关用户信息）
     * create time: 2019/9/8 20:32
     * [userId, model]
     * @return java.lang.String
     */
    @GetMapping(value = "/modifyUser/{userid}")
    public String modifyUser(@PathVariable(value = "userid") Integer userId, Model model) throws BusinessExcpetion {
        //调取相应Model 业务逻辑数据
        User user = userService.findUserById1(userId);

        //        需要将UserModel转换成UserVO（供用户来查看的信息）
        UserVO userVO = convertFromModel(user);
        model.addAttribute("user", user);
        return "user/usermodify";
    }

    /**
     * description: TODO 处理用户的修改
     * create time: 2019/9/8 22:08
     * [user, session]
     *
     * @return java.lang.String
     */
    @PostMapping(value = "/usermodifysave")
    public String usermodifySave(User user, HttpSession session) throws BusinessExcpetion {

        //设置谁修改了数据
        user.setModifyBy(((User) session.getAttribute(Constants.USERSESSION)).getId());
        user.setModifyDate(new Date());
//        调用修改用户业务
        Integer result = userService.modifyUser(user);
        if (result > 0) {
            return Constants.REDIRECT + "userList";
        } else {
            return "user/usermodify";
        }
    }

    @GetMapping(value = "/delUser/{userId}")
    @ResponseBody
    public CommonReturnType delUser(@PathVariable(value = "userId")Integer userid)throws BusinessExcpetion{
        if (userid==null){
            throw new BusinessExcpetion(EmBusinessError.ILLEGAL_ARGS);
        }
        int result = userService.delUserById(userid);
        return CommonReturnType.create(result);
    }


}
