package com.codebysuraj.useraccountregistration.service;

import com.codebysuraj.useraccountregistration.model.ResetToken;
import com.codebysuraj.useraccountregistration.repository.ResetRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resetService")
public class ResetService {

    @Autowired
    private ResetRepositry resetRepositry;

    public ResetToken findByResetToken(String resetToken)
    {
        return resetRepositry.findByResetToken(resetToken);
    }
    public void save(ResetToken resetToken)
    {
        resetRepositry.save(resetToken);
    }
}
