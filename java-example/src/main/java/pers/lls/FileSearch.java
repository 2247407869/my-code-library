package pers.lls;

import java.io.*;
import java.util.regex.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;

public class FileSearch {
    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\22474\\IdeaProjects\\my-code-library\\java-example\\src\\main\\resources\\fileSearch";  // 替换为你要读取的目录路径
        String searchString = "(?<=<SvcCd>).*?(?=</SvcCd>)";  // 替换为你要搜索的字符串

        // 设置CSV文件路径和名称
        String csvFilePath = "C:\\Users\\22474\\IdeaProjects\\my-code-library\\java-example\\src\\main\\resources\\fileSearch\\结果.csv";

        try {
            // 创建CSV文件并写入表头
            FileWriter csvWriter = new FileWriter(csvFilePath);
            csvWriter.append("文件名,包裹的字符\n");

            // 递归遍历目录下的所有文件
            Files.walk(Paths.get(directoryPath)).filter(Files::isRegularFile).forEach(filePath -> {
                try {
                    // 读取文件内容
                    String fileContent = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);

                    // 使用正则表达式匹配指定字符串的内容
                    Pattern pattern = Pattern.compile("(" + searchString + ")");
                    Matcher matcher = pattern.matcher(fileContent);

                    // 记录匹配到的结果到CSV文件
                    while (matcher.find()) {
                        String matchedString = matcher.group(1);
                        csvWriter.append(filePath.getFileName().toString()).append(",").append(matchedString).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // 关闭CSV文件写入器
            csvWriter.flush();
            csvWriter.close();

            System.out.println("已成功生成CSV文件：" + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}