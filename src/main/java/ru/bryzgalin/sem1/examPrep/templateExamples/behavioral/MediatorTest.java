package ru.bryzgalin.sem1.examPrep.templateExamples.behavioral;

import java.util.ArrayList;
import java.util.List;

/*
Mediator (Посредник)
Предоставляет класс посредника, который обрабатывает все связи между различными классами.
 */
// 1. Интерфейс посредника
interface ChatMediator {
    void sendMessage(String msg, User user);
    void addUser(User user);
}

// 2. Конкретный посредник
class ChatRoom implements ChatMediator {
    private List<User> users;

    public ChatRoom() {
        this.users = new ArrayList<>();
    }

    @Override
    public void sendMessage(String msg, User user) {
        for (User u : users) {
            if (u != user) { // Не отправляем сообщение отправителю
                u.receive(msg);
            }
        }
    }

    @Override
    public void addUser(User user) {
        this.users.add(user);
    }
}

// 3. Класс пользователя
class User {
    private String name;
    private ChatMediator mediator;

    public User(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    public String getName() {
        return name;
    }

    public void send(String msg) {
        System.out.println(this.name + " отправляет: " + msg);
        mediator.sendMessage(msg, this);
    }

    public void receive(String msg) {
        System.out.println(this.name + " получает: " + msg);
    }
}

// 4. Клиентский код
public class MediatorTest {
    public static void main(String[] args) {
        ChatMediator chatRoom = new ChatRoom();

        User user1 = new User("user1", chatRoom);
        User user2 = new User("user2", chatRoom);
        User user3 = new User("user3", chatRoom);

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        user1.send("Привет всем!");
        user2.send("Привет, user1!");
    }
}