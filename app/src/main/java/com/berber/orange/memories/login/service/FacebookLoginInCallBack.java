package com.berber.orange.memories.login.service;

import com.facebook.login.LoginResult;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by yinya
 * on 03.10.2017.
 */

public interface FacebookLoginInCallBack extends BaseLoginInCallBack {

    void facebookLoginSucceed(LoginResult loginResult);

    void facebookLoginCancel();

    void facebookLoginOnError();


    void facebookLoginWithFireBaseSucceed(FirebaseUser user);

    void facebookLoginWithFireBaseFailure(Task<AuthResult> task);
}
