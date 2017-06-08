
package com.mycompany.homelan;

public class JObject {

     
    private String name;
    private int age;
    private String messages;
     
    // Пустой конструктор
    public JObject() {} 
    
    // Конструктор с параметрами
    public JObject(String name, int age, String messages) {
        this.name = name;
        this.age = age;
        this.messages = messages;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public String getMessages() {
        return messages;
    }
 
    public void setMessages(String messages) {
        this.messages = messages;
    }
 
    @Override
    public String toString() {
        return "User [name=" + name + ", age=" + age + ", messages="
                + messages + "]";
    }
    
}
