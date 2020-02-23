import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends javax.servlet.http.HttpServlet {

    private String message;

    public void init() throws ServletException
    {
        // 初始化
        message = "Hello, First Servlet!";
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        // 设置:响应内容类型
        response.setContentType("text/html");

        // 输出文本
        PrintWriter out = response.getWriter();
        out.write("<h1> " + message + " </h1>");
    }
}
