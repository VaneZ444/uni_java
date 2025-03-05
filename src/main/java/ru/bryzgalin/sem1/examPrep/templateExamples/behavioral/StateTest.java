package ru.bryzgalin.sem1.examPrep.templateExamples.behavioral;
/*
State
Позволяет объекту изменять свое поведение в зависимости от его состояния.
 */
interface State {
    void doAction(PlayContext context);
}

class StartPlay implements State {
    @Override
    public void doAction(PlayContext context) {
        System.out.println("Воспроизведение начато.");
        context.setState(new StopPlay()); // Переключаем состояние на StopPlay
    }
}

class StopPlay implements State {
    @Override
    public void doAction(PlayContext context) {
        System.out.println("Воспроизведение остановлено.");
        context.setState(new StartPlay()); // Переключаем состояние на StartPlay
    }
}

class PlayContext {
    private State state;

    public PlayContext() {
        this.state = new StopPlay(); // Начальное состояние
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction(this); // Делегируем выполнение текущему состоянию
    }
}

public class StateTest {
    public static void main(String[] args) {
        PlayContext playContext = new PlayContext();

        playContext.doAction(); // Воспроизведение начато
        playContext.doAction(); // Воспроизведение остановлено
        playContext.doAction(); // Воспроизведение начато
    }
}