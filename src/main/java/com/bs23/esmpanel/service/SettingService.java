package com.bs23.esmpanel.service;

import com.bs23.esmpanel.repositories.SettingRepository;
import com.bs23.esmpanel.model.Setting;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingService {

    final SettingRepository settingRepository;

    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    public void save(Setting setting) {
        settingRepository.save(setting);
    }

    public Optional<Setting> findByAttribute(String attribute) {
        return settingRepository.findByAttribute(attribute);
    }

    public Long getLowestGradeBasicSalaryValue() {
        return Long.parseLong(settingRepository.getSettingByAttribute("lowest_grade_basic_salary").getValue());
    }

    public void updateBasicSalaryOfLowestGrade(Setting setting) {
        var newSetting = settingRepository.findByAttribute(setting.getAttribute()).get();
        BeanUtils.copyProperties(setting, newSetting);
        settingRepository.save(newSetting);
    }

}
