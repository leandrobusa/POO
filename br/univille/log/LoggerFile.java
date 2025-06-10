package br.univille.log;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFile implements Logger {

    private static final String FILE_NAME = "log.txt";

    @Override
    public void log(Level level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String fullMessage = String.format("[%s] [%s] %s%n", timestamp, level, message);

        try {
            Files.write(Paths.get(FILE_NAME),
                        fullMessage.getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo de log.");
            e.printStackTrace();
        }
    }
}
