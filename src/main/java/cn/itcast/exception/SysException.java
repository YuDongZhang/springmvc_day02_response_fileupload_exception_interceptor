package cn.itcast.exception;

/**
 * 自定义的异常类
 */
public class SysException extends Exception {
    // 存储提示信息的
    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}
