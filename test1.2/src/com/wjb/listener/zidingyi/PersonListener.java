package com.wjb.listener.zidingyi;

/**
* @ClassName: PersonListener(�¼�������)
* @Description: ���Person��(�¼�Դ)�ļ������ӿ�
* @author: �°�����
* @date: 2014-9-9 ����9:28:06
*
*/ 
interface PersonListener {

    /**
    * @Method: doeat
    * @Description: �����������������Person����eat(��)�����Ϊ������
    *                 ��ʵ����ʵ��doeat����ʱ�Ϳ��Լ�����Person�����eat(��)�������
    * @Anthor:�°�����
    *
    * @param e
    */ 
    void doeat(Event e);

    /**
    * @Method: dorun
    * @Description: �����������������Person����run(��)�����Ϊ������
    *                 ��ʵ����ʵ��dorun����ʱ�Ϳ��Լ�����Person�����run(��)�������
    * @Anthor:�°�����
    *
    * @param e
    */ 
    void dorun(Event e);

}