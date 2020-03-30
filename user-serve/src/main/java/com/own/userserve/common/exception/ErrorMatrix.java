/**
 * 系统错误信息常量类
 *
 * @author whl
 * 2017-11-22
 */
package com.own.userserve.common.exception;


/**
 * 用户操作提示信息集中定义类
 */

public class ErrorMatrix {

    /**
     * 参数异常
     */
    public static final String PARAMS_ERROR = "参数异常！";

    public final static String INVALID_PARAMTER = "无效的参数";


    /**
     * 数据库异常，请稍候再试！
     */
    public final static String DB_SAVE_FAIL = "数据库异常，请稍候再试！";

    /**
     * 登录
     */
    public final static String LOG_SUCCESS = "登录成功！";
    /**
     *
     */
    public final static String LOG_LOGOUT = "退出登录成功！";
    /**
     *
     */
    public final static String LOG_FAIL = "未登录，请先登录！";

    /**
     *
     */
    public final static String LOG_CODE_FAIL = "验证码不能为空！";
    /**
     *
     */
    public final static String LOG_CODE_ERROR = "验证码错误！";

    public final static String LOG_NO_SUCCESS = "账号被禁用！";

    /**
     * 提交成功
     */
    public final static String DB_SAVE_SUCCESS = "提交成功！";
    /**
     * 提交失败
     */
    public final static String DB_SAVE_CASE_FAIL = "提交失败！";


    /**
     * 修改成功
     */
    public final static String DB_UPDATE_SUCCESS = "修改成功！";
    /**
     * 修改失败
     */
    public final static String DB_UPDATE_FAIL = "修改失败！";

    public final static String DB_UPDATE_PASSWORD_FAIL = "原始密码错误！";

    /**
     * 修改已修改的信息失败
     */
    public final static String DB_UPDATE_INFO_FAIL = "信息已被修改，请刷新后重试！";

    /**
     * 查询成功
     */
    public final static String DB_QUERY_SUCCESS = "查询成功！";
    /**
     * 没有查询结果
     */
    public final static String DB_QUERY_NO_DATA = "没有查询结果！";

    /**
     * 删除失败
     */
    public final static String DB_DEL_FAIL = "删除失败！";
    /**
     * 删除成功
     */
    public final static String DB_DEL_SUCCESS = "删除成功！";

    /**
     * 无权限
     */
    public final static String NO_AUTH = "无访问权限！";

    /**
     * 无权限
     */
    public final static String USER_ERROR = "账号或密码错误！";

    /**
     * 操作失败标识符
     */
    public final static String OP_NG = "NG";
    /**
     * 操作成功标识符
     */
    public final static String OP_OK = "OK";

    /**
     * 数据库备份成功
     */
    public final static String MYSQL_BACKUP_SUCCESS = "数据库备份成功！";
    /**
     * 数据库备份失败
     */
    public final static String MYSQL_BACKUP_FAIL = "数据库备份失败！";

    /**
     * 数据库恢复成功
     */
    public final static String MYSQL_RESTORE_SUCCESS = "数据库恢复成功！";
    /**
     * 数据库恢复失败
     */
    public final static String MYSQL_RESTORE_FAIL = "数据库恢复失败！";

    /**
     * 请选择正确的备份文件
     */
    public final static String ERROR_FILE = "请选择正确的备份文件！";

    /**
     * 查询记录失败
     */
    public final static String QUERY_FAIL = "服务器忙，请重试";

    /**
     * 文件模板错误
     */
    public final static String FILE_TEMPLATE_ERROR = "文件格式错误,请下载模板";

    public final static String SYS_FILE_ERROR="服务器异常，请联系管理员！";
    /**
     * 分类添加层级限制
     */
    public final static String OVER_MAX_LEVEL = "分类层数不能超过10层，无法添加";

    /**
     * 该角色有用户使用无法删除
     */
     public final static  String ROLE_NO_DEL="该角色有用户使用无法删除";
    /**
     * 该叫色无法删除对应的code，方便前端判断
      */
      public  final static String CODE_ROLE_NO_DEL="600";

    /**
     * 无法删除，被使用中
     */
    public final static  String USE_NO_DEL="无法删除被使用中";
    /**
     * 无法删除被使用中对应的code
     */
    public  final static String CODE_USE_DEL="601";





    public final static String CODE_OK = "200";
    public final static String CODE_FAILED = "201";
    public final static String CODE_INVALID_PARAMTER = "202";
    public final static String CODE_NO_DATA = "203";
    public final static String CODE_EXCEPTION = "400";
    public final static String CODE_LOGIN_FAILED = "503";
    public final static String CODE_FAILED_VERFIFY = "504";
    public final static String CODE_NO_AUTH = "512";
    public final static String SYS_FAILED = "514";
    public final static String CODE_NOOK = "300";



}
