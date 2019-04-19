package com.paazl.cases.common.developers;

import com.paazl.cases.common.developers.impl.JunoirDeveloper;
import com.paazl.cases.common.developers.impl.MediorDeveloper;
import com.paazl.cases.common.developers.impl.SeniorDeveloper;

public class DeveloperFactory {
    public static Developer create(int score){
        return score < 4 ? new JunoirDeveloper() : (score < 8 ? new MediorDeveloper() : new SeniorDeveloper());
    }
}
