package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Option;

public interface IOptionService {

    Option saveOption(Option option);

    Option updateOption(Long id, Option updatedOption);

    void deleteOption(Long id);
}

