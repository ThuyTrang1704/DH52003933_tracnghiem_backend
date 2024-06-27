package com.tracnghiem.demo.Service;

import com.tracnghiem.demo.Entity.Option;
import com.tracnghiem.demo.Repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class OptionServiceImpl implements IOptionService {

    @Autowired
    private OptionRepository optionRepository;

    @Override
    public Option saveOption(Option option) {
        return optionRepository.save(option);
    }

    @Override
    public Option updateOption(Long id, Option updatedOption) {
        Option existingOption = optionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Option not found with id: " + id));

        existingOption.setContent(updatedOption.getContent());
       // existingOption.setCorrect(updatedOption.isCorrect());

        return optionRepository.save(existingOption);
    }

    @Override
    public void deleteOption(Long id) {
        optionRepository.deleteById(id);
    }
}


