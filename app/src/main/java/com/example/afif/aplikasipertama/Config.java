package com.example.afif.aplikasipertama;

/**
 * Created by afif on 7/14/2016.
 */
public class Config {

    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://192.168.1.14//android/addEmp.php";
    public static final String URL_GET_ALL = "http://192.168.1.14/android/getAllEmp.php";
    public static final String URL_GET_EMP = "http://192.168.1.14/android/getEmp.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.14/android/updateEmp.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.14/android/deleteEmp.php?id=";
    public static final String URL_LOGIN ="http://192.168.1.14/android/cek_login.php";
    public static final String URL_DAFTAR ="http://192.168.1.14/android/proses_pendaftara.php";
    public static final String URL_CEK_EMAIL ="http://192.168.1.14/android/cek_email.php";
    public static final String URL_CEK_USERNAME ="http://192.168.1.14/android/cek_username.php";


    //Keys that will be used to send the request to php scripts
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAME = "name";
    public static final String KEY_EMP_DESG = "desg";
    public static final String KEY_EMP_SAL = "salary";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAMA = "nama";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TELP = "no_telp";




    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAME = "name";
    public static final String TAG_DESG = "desg";
    public static final String TAG_SAL = "salary";

    //employee id to pass with intent
    public static final String EMP_ID = "emp_id";
}
