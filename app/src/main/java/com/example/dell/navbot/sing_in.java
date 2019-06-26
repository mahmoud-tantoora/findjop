package com.example.dell.navbot;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sing_in extends AppCompatActivity {
    private static final String TAG = "singin";
    @BindView(R.id.input_name) EditText _nameText;
    @BindView(R.id.input_typework) EditText _TypeText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.input_mobile) EditText _mobileText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @BindView(R.id.btn_signup) Button _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;
    @BindView(R.id.spinner_type) Spinner _spinnertype;
    int idw,mistake=0,mistake1=0,idc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singin);

        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int spValue;

                String name,type,email,mobile,password;
                ApiInterface apiInterface;

                Toast.makeText(getApplicationContext(),"Ana hoon lsaa",Toast.LENGTH_SHORT).show();
                String value_spinner = _spinnertype.getSelectedItem().toString();
                if(value_spinner.equals("COMPANY"))
                    spValue=0;
                else
                    spValue=1;

                name = _nameText.getText().toString();
                type = _TypeText.getText().toString();
                email = _emailText.getText().toString();
                mobile = _mobileText.getText().toString();
                password = _passwordText.getText().toString();
                apiInterface =ApiClient.getApiClient().create(ApiInterface.class);
                if(spValue==1) {
                   try {


                       Call<insertwork_getCount> call = apiInterface.insert_worker(name, type, Integer.parseInt(mobile));
                       call.enqueue(new Callback<insertwork_getCount>() {
                           @Override
                           public void onResponse(Call<insertwork_getCount> call, Response<insertwork_getCount> response) {

                           }

                           @Override
                           public void onFailure(Call<insertwork_getCount> call, Throwable t) {
                               mistake = 1;
                           }
                       });
                       /// get  id_worker  number

                       Call<Response_user> call1 = apiInterface.getcounts(Integer.parseInt(mobile));
                       call1.enqueue(new Callback<Response_user>() {
                           @Override
                           public void onResponse(Call<Response_user> call, Response<Response_user> response) {
                               Response_user response_user = response.body();

                               idw = Integer.parseInt(response_user.getResponse());

                           }

                           @Override
                           public void onFailure(Call<Response_user> call, Throwable t) {
                               mistake = 1;
                           }
                       });

                       Call<insert_email_worker> call3 = apiInterface.insert_email_worker(email, idw, password, Integer.parseInt(mobile), spValue);
                       call3.enqueue(new Callback<insert_email_worker>() {
                           @Override
                           public void onResponse(Call<insert_email_worker> call, Response<insert_email_worker> response) {
                               insert_email_worker insert_email = response.body();

                               String result = insert_email.getMessage();
                               if (result.equals("Successfully"))
                                   Toast.makeText(getApplicationContext(), "Account Worker successfully created ", Toast.LENGTH_LONG).show();
                               else
                                   Toast.makeText(getApplicationContext(), "Not connected with Internet Or Account is Exist with this mobile Number  ", Toast.LENGTH_SHORT).show();

                           }

                           @Override
                           public void onFailure(Call<insert_email_worker> call, Throwable t) {


                           }
                       });
                   idw=0;
                }catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),"Not connected with Internet Or Account is Exist with this mobile Number  ",Toast.LENGTH_SHORT).show();
                }
                   }

                else    // user   chech   company

                {
                    //Toast.makeText(getApplicationContext(),"Ana ggggg",Toast.LENGTH_SHORT).show();
                  try {


                    String specializing = type;
                    Call<insert_company> call = apiInterface.insert_company(name, specializing, Integer.parseInt(mobile));
                    call.enqueue(new Callback<insert_company>() {
                        @Override
                        public void onResponse(Call<insert_company> call, Response<insert_company> response) {
                            //    insert_company  in = response.body();

                            //      Toast.makeText(getApplicationContext(),in.getMessage(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<insert_company> call, Throwable t) {
                            //  Toast.makeText(getApplicationContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                            mistake1 = 1;
                        }
                    });
                    /// get id_company   number

                    Call<Response_user> call1 = apiInterface.get_id_company(Integer.parseInt(mobile));
                    call1.enqueue(new Callback<Response_user>() {
                        @Override
                        public void onResponse(Call<Response_user> call, Response<Response_user> response) {
                            Response_user response_user = response.body();

                            idc = Integer.parseInt(response_user.getResponse());
                            Toast.makeText(getApplicationContext(),idc,Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<Response_user> call, Throwable t) {
                            mistake1 = 1;
                        }
                    });


                        Call<insert_email_company> call3 = apiInterface.insert_email_company(email, idc, password, Integer.parseInt(mobile), spValue);
                        call3.enqueue(new Callback<insert_email_company>() {
                            @Override
                            public void onResponse(Call<insert_email_company> call, Response<insert_email_company> response) {
                                insert_email_company insert_email = response.body();

                                String result = insert_email.getMessage();
                                if (result.equals("Successfully"))
                                    Toast.makeText(getApplicationContext(), "Account Company successfully created ", Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(getApplicationContext(), "Not connected with Internet Or Account is Exist with this mobile Number  ", Toast.LENGTH_SHORT).show();

                            }

                            @Override
                            public void onFailure(Call<insert_email_company> call, Throwable t) {


                            }
                        });
                        idc=0;
                  }catch (Exception e)
                  {
                      Toast.makeText(getApplicationContext(),"Not connected with Internet Or Account is Exist with this mobile Number  ",Toast.LENGTH_SHORT).show();
                  }
                }


                //signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),login.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }


    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(sing_in.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Creating Account...");
        progressDialog.show();

        String name = _nameText.getText().toString();
        String address = _TypeText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String address = _TypeText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (address.isEmpty()) {
            _TypeText.setError("Enter Valid Address");
            valid = false;
        } else {
            _TypeText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=20) {
            _mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 20) {
            _passwordText.setError("between 4 and 20 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 20 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }
}