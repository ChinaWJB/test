package com.wjb.listener.zidingyi;

/**
* @ClassName: Person(�¼�Դ)
* @Description: ���һ��Person����Ϊ�¼�Դ�������Ķ������Ϊ(����Է����ܲ�)���Ա������Ķ������
* @author: �°�����
* @date: 2014-9-9 ����9:26:06
*
*/  
public class Person {
    /**
    * @Field: listener
    *          ��Person���ж���һ��PersonListener��������ס���ݽ����ļ�����
    */ 
    private PersonListener listener;

    /**
    * @Method: eat
    * @Description: ���Person����Ϊ����
    * @Anthor:�°�����
    *
    */ 
    public void eat() {
        if (listener != null) {
            /**
             * ���ü�������doeat��������Person�����eat(��)������������¼�����Event���ݸ�doeat������
             * �¼������װ���¼�Դ��new Event(this)�е�this�����ľ����¼�Դ
             */
            listener.doeat(new Event(this));
        }
    }

    /**
    * @Method: run
    * @Description: ���Person����Ϊ����
    * @Anthor:�°�����
    *
    */ 
    public void run() {
        if (listener != null) {
            /**
             * ���ü�������dorun��������Person�����run(��)������������¼�����Event���ݸ�doeat������
             * �¼������װ���¼�Դ��new Event(this)�е�this�����ľ����¼�Դ
             */
            listener.dorun(new Event(this));
        }
    }

    /**
    * @Method: registerListener
    * @Description: �������������ע���Person��������Ϊ���м����ļ�����
    * @Anthor:�°�����
    *
    * @param listener
    */ 
    public void registerListener(PersonListener listener) {
        this.listener = listener;
    }
}