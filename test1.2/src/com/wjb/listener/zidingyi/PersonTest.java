package com.wjb.listener.zidingyi;

public class PersonTest {

    /**
     * @Method: main
     * @Description: ����Person��
     * @Anthor:�°�����
     *
     * @param args
     */
    public static void main(String[] args) {
        //
        Person p = new Person();
        //ע�����p������Ϊ�ļ�����
        p.registerListener(new PersonListener() {
            //����p�Զ��������Ϊ
            public void doeat(Event e) {
                Person p = e.getSource();
                System.out.println(p + "�ڳԶ���");
            }
            //����p�ܲ������Ϊ
            public void dorun(Event e) {
                Person p = e.getSource();
                System.out.println(p + "���ܲ�");
            }
        });
        //p�ڳԶ���
        p.eat();
        //p���ܲ�
        p.run();
    }
}