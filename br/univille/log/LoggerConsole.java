package br.univille.log;

class LoggerConsole implements Logger {

    @Override
    public void log(Level level, String message) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RED = "\u001B[31m";

        String color;
        switch (level) {
            case DEBUG:
                color = ANSI_GREEN;
                break;
            case WARNING:
                color = ANSI_YELLOW;
                break;
            case ERROR:
                color = ANSI_RED;
                break;
            default:
                color = ANSI_RESET;
        }

        System.out.println(color + "[" + level + "] " + message + ANSI_RESET);
    }
}
