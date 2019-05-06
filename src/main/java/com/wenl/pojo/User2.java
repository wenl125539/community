package com.wenl.pojo;

import org.springframework.web.multipart.MultipartFile;

public class User2 extends User {

    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
