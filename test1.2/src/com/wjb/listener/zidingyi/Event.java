package com.wjb.listener.zidingyi;

/**
* @ClassName: Event(�¼�����)
* @Description:����¼��࣬������װ�¼�Դ
* @author: �°�����
* @date: 2014-9-9 ����9:37:56
*
*/ 
class Event {

    /**
    * @Field: source
    *          �¼�Դ(Person�����¼�Դ)
    */ 
    private Person source;

    public Event() {
        
    }

    public Event(Person source) {
        this.source = source;
    }

    public Person getSource() {
        return source;
    }

    public void setSource(Person source) {
        this.source = source;
    }
}