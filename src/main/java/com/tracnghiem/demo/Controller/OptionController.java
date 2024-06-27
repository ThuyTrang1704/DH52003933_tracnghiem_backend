package com.tracnghiem.demo.Controller;

import com.tracnghiem.demo.Entity.Option;
import com.tracnghiem.demo.Service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/options")
public class OptionController {

        @Autowired
        private IOptionService optionService;

        @PostMapping("/")
        public Option addOption(@RequestBody Option option) {
            return optionService.saveOption(option);
        }

        @PutMapping("/{id}")
        public Option updateOption(@PathVariable Long id, @RequestBody Option updatedOption) {
            return optionService.updateOption(id, updatedOption);
        }

        @DeleteMapping("/{id}")
        public void deleteOption(@PathVariable Long id) {
            optionService.deleteOption(id);
        }
    }

