package pers.lls;

import java.io.*;
import java.util.Base64;

public class ProcessFile {
    public static void main(String[] args) {
        // 文件路径
        String inputFilePath = "C:\\Users\\22474\\Documents\\WeChat Files\\wxid_fbqmekg3wy0q22\\FileStorage\\File\\2024-10\\attachExport.txt"; // 输入文件路径
        String outputFilePath = "C:\\Users\\22474\\Documents\\WeChat Files\\wxid_fbqmekg3wy0q22\\FileStorage\\File\\2024-10\\output_file.txt"; // 输出文件路径

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            StringBuilder currentLine = new StringBuilder(); // 用来拼接行的字符串
            String line;

            while ((line = reader.readLine()) != null) {
                // 如果行中不包含 "|"
                if (!line.contains("M |")) {
                    // 将该行的内容拼接到当前行的后面（去除换行符）
                    currentLine.append(line.trim());
                } else {
                    // 处理前一行（包含拼接内容）
                    if (currentLine.length() > 0) {
                        // 按照 "|" 分割前一行
                        processAndWriteLine(currentLine +line.trim(), writer);
                        // 清空 currentLine
                        currentLine.setLength(0);
                    }
                }
            }

            // 处理最后拼接的行
            if (currentLine.length() > 0) {
                processAndWriteLine(currentLine.toString(), writer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 处理并写入一行数据，进行 Base64 解码
    private static void processAndWriteLine(String line, BufferedWriter writer) throws IOException {
        // 按 "|" 分割
        String[] parts = line.split("\\|");
        if (parts.length > 0) {
            // 取第一部分，去除空白字符
            String firstPart = parts[0].trim();

            // 尝试进行 Base64 解码
            try {
                byte[] decodedBytes = Base64.getDecoder().decode(firstPart);
                String decodedString = new String(decodedBytes, "UTF-8");

                // 写入输出文件
                writer.write(decodedString);
                // 写入剩余的部分
                for (int i = 1; i < parts.length; i++) {
                    writer.write(" | " + parts[i].trim()); // 保留原始的其他部分
                }
                writer.newLine();
            } catch (IllegalArgumentException e) {
                // 如果解码失败，跳过该行
                System.out.println("Base64解码失败: " + firstPart);
            }
        }
    }
}
