package com.example.levin.thread;

import java.util.*;

class StateCode {
    private String code;
    private String description;

    public StateCode(String code, String description) {
        this.code = code;
        this.description=description;
    }

    public String getCode() {
        return code;
    }


    @Override
	public int hashCode() {
		return Objects.hash(code,description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateCode other = (StateCode) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "StateCode [code=" + code + ", description=" + description + "]";
	}

	
}

public class HashingDemo {
    public static void main(String[] args) {
        Set<StateCode> stateSet = new HashSet<>();

        stateSet.add(new StateCode("TN","Tamilnadu"));
        stateSet.add(new StateCode("KA","Karnataka"));
        stateSet.add(new StateCode("KL","Kerala"));
        stateSet.add(new StateCode("TN","Tamilnadu")); 

        System.out.println(stateSet); 
    }
}
