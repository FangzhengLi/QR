package com.example.qrhunter;

import static android.content.ContentValues.TAG;
import static com.google.zxing.integration.android.IntentIntegrator.REQUEST_CODE;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.FileUtils;
import android.provider.MediaStore;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
<<<<<<< HEAD
import com.google.firebase.storage.UploadTask;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
=======
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
<<<<<<< HEAD
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
=======
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SharedPicture extends AppCompatActivity {
    String imagePath;
    FirebaseFirestore db;
    String qrCode;
<<<<<<< HEAD
    Uri filePath;
    int PICK_IMAGE_REQUEST = 111;
    private File picture;

    FirebaseStorage storage = FirebaseStorage.getInstance();
    StorageReference storageRef = storage.getReferenceFromUrl("gs://w301t34.appspot.com");    //change the url according to your firebase app
=======
    private final static int mWidth = 512;
    private final static int mLength = 512;
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf

    private ArrayList<String> pathArray;
    private int array_position;

    private ProgressDialog mProgressDialog;
    private StorageReference mStorageRef;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_picture);
        SharedData appData = (SharedData) getApplication();
        qrCode = appData.getQrcode();

        Button notBtn = findViewById(R.id.btntxt);
        notBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db = FirebaseFirestore.getInstance();
                HashScore hashScore = new HashScore();
                CollectionReference codesRef = db.collection("QRCodes");
                DocumentReference docCodeRef = codesRef.document(hashScore.hash256(qrCode));
                docCodeRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            //ArrayList<String> userList = (ArrayList<String>) document.get("scanners");
                            //userList.add(userName);
                            Map<String, Object> data = new HashMap<>();
                            data.put("sharedPicture", false);
                            docCodeRef.set(data, SetOptions.merge());
                        }
                    }
                });
                Intent intent = new Intent(SharedPicture.this, SharedGeo.class);
                startActivity(intent);
            }



        });

        Button select = findViewById(R.id.btnSelect);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });

        Button share = findViewById(R.id.btnShare);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
               notBigPhoto();
               if(filePath != null) {
                   Log.e("onClick: ",filePath+"" );
                   SharedData appData = new SharedData();
                   String name =appData.getUsername();
                   Date date = new Date(System.currentTimeMillis());
                   SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMddHHmmss");
                   String image_save_path =  sdf.format(date);
                   StorageReference childRef = storageRef.child(name+image_save_path+".jpg");
                   //uploading the image
                    UploadTask uploadTask = childRef.putFile(filePath);
                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(SharedPicture.this, "Upload successful", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(SharedPicture.this, "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(SharedPicture.this, "Select an image", Toast.LENGTH_SHORT).show();
                }
=======
                notBigPhoto();
                //Intent intent = new Intent(SharedPicture.this, SharedGeo.class);
                //startActivity(intent);
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf


                db = FirebaseFirestore.getInstance();
                HashScore hashScore = new HashScore();
                CollectionReference codesRef = db.collection("QRCodes");
                DocumentReference docCodeRef = codesRef.document(hashScore.hash256(qrCode));
                docCodeRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                            Map<String, Object> data = new HashMap<>();
                            data.put("sharedPicture", true);
                            docCodeRef.set(data, SetOptions.merge());
                        }
                    }
                });
            }



            //Intent intent = new Intent(SharedPicture.this, SharedGeo.class);
            //startActivity(intent);


        });

        Button back = findViewById(R.id.btnBackToScan);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  Intent intent = new Intent(SharedPicture.this, ScoreActivity.class);
              //  startActivity(intent);
            finish();
            }
        });


        //take a photo or use the code photo
        Button image = findViewById(R.id.btnphoto);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView imageView = findViewById(R.id.imgQrcode);
                SharedData appData = (SharedData) getApplication();
                imagePath = appData.getImagepath();
                File file = new File(imagePath);
                imageView.setImageURI(Uri.fromFile(file));

            }
        });

        Button take = findViewById(R.id.btnTake);
        take.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();

            }
        });


    }


<<<<<<< HEAD


    public void notBigPhoto(){
        //SharedData appData = (SharedData) getApplication();
        //imagePath = appData.getImagepath();
        File file = new File(String.valueOf(filePath));
        double size = getFileOrFilesSize(file);
        Log.e("size", ""+size);
        if(size<=64){
=======
    public void notBigPhoto() {
        SharedData appData = (SharedData) getApplication();
        imagePath = appData.getImagepath();
        File file = new File(imagePath);
        double size = getFileOrFilesSize(file);
        //Log.e(TAG, ""+size);
        if (size <= 64) {
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);//Environment.getExternalStorageDirectory().getAbsolutePath() + "/compresstest/test.png"
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String str = "2";
            int quality = Integer.parseInt(str);
            if (bitmap != null) {
//            bitmap.compress(Bitmap.CompressFormat.PNG, quality, baos); // 设置Bitmap.CompressFormat.PNG，quality将不起作用，PNG是无损压缩
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
                byte[] bytes = baos.toByteArray();
                Bitmap newBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

            }

        }

<<<<<<< HEAD
=======

        //Bitmap bitmap = BitmapFactory.decodeFile(imagePath);//Environment.getExternalStorageDirectory().getAbsolutePath() + "/compresstest/test.png"
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //String str = "2";//edtvQuality.getText().toString();
        //int quality = 100;
        //try {
        //int quality = Integer.parseInt(str);
        //  } catch (Exception e) {
        //Toast.makeText(this, "请输入有效数字内容", Toast.LENGTH_SHORT).show();
        //    e.printStackTrace();
        // return ;
        //}
        //  if(bitmap != null) {
//       //     bitmap.compress(Bitmap.CompressFormat.PNG, quality, baos); // 设置Bitmap.CompressFormat.PNG，quality将不起作用，PNG是无损压缩
        //    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, baos);
        //    byte[] bytes = baos.toByteArray();
        //   Bitmap newBitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        //String info = " quality: " + quality + " 压缩图片大小: " + (newBitmap.getByteCount()) + " 压缩后文件大小: " + (bytes.length) + " 宽度为: " + newBitmap.getWidth() + " 高度为: " + newBitmap.getHeight();
        //  Log.e("quality", ""+bytes.length);
        // tvCompress.setText(info);
        // imgvCompress.setImageBitmap(newBitmap);
        //  }

        // if(size>=64){
        //     changeSize();
        // }

        savePhoto();
        Intent intent = new Intent(SharedPicture.this, SharedGeo.class);
        startActivity(intent);
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf
    }


    public static double getFileOrFilesSize(File file) {

        long blockSize = 0;
        try {
            if (file.isDirectory()) {
                blockSize = getFileSizes(file);
            } else {
                blockSize = getFileSize(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Log.e("fail","not exist!");
        }
        return FormetFileSize(blockSize);
    }

    private static double FormetFileSize(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        double fileSizeLong = 0;
        fileSizeLong = Double.valueOf(df.format((double) fileS / 1024));
        return fileSizeLong;

    }

    private static long getFileSizes(File f) throws Exception {
        long size = 0;
        File flist[] = f.listFiles();
        for (int i = 0; i < flist.length; i++) {
            if (flist[i].isDirectory()) {
                size = size + getFileSizes(flist[i]);
            } else {
                size = size + getFileSize(flist[i]);
            }
        }
        return size;
    }

    private static long getFileSize(File file) throws Exception {
        long size = 0;
        if (file.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(file);
            size = fis.available();
        } else {
            file.createNewFile();
            // Log.e("fail","not exit!");
        }
        return size;
    }


<<<<<<< HEAD


    public void takePhoto(){
=======
    public void takePhoto() {
        startCamera();
        //take photo save at sharedData which use to check the picture size, put on the view


        //after taking, put on the view
        //ImageView imageView = findViewById(R.id.imgQrcode);
        //SharedData appData = (SharedData) getApplication();
        //imagePath = appData.getImagepath();
        // File file = new File(imagePath);
        //imageView.setImageURI(Uri.fromFile(file));
    }

    private void startCamera() {
        //可以打开摄像头并照相
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 2);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if (requestCode == 2 && resultCode == RESULT_OK && null != data) {
            Bundle bundle = data.getExtras();
            //获取相机返回的数据，并转换为Bitmap图片格式，这是缩略图
            Bitmap bitmap = (Bitmap) bundle.get("data");
            ImageView imageView = findViewById(R.id.imgQrcode);
            imageView.setImageBitmap(bitmap);
            saveScreenShot(bitmap);

        }


        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                //getting image from gallery
                //Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
                //imgView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

<<<<<<< HEAD
    private void saveScreenShot(Bitmap bitmap)  {
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        OutputStream outStream = null;
        //以保存时间为文件名
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyyMMddHHmmss");
        String image_save_path =  sdf.format(date);

        File file = new File(extStorageDirectory, image_save_path+".jpg");//创建文件，第一个参数为路径，第二个参数为文件名
        //String picturePath=file.getPath();
        //if (!file.exists()) {
           // file.mkdir();
       // }


        try {
           outStream = new FileOutputStream(file);//创建输入流
             bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream);
           outStream.close();
//       这三行可以实现相册更新
            Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            Uri uri = Uri.fromFile(file);
            intent.setData(uri);
            sendBroadcast(intent);

        } catch(Exception e) {
            Toast.makeText(SharedPicture.this, "exception:" + e,
                    Toast.LENGTH_SHORT).show();
        }
    }




    }



=======
    //save the picture on the firebase

    public void savePhoto() {
        // hash
//        db = FirebaseFirestore.getInstance();
//        SharedData appData = new SharedData();
//        HashScore hashScore = new HashScore();
//        CollectionReference codeRef = db.collection("QRCodes");
//        DocumentReference docCodeRef = codeRef.document(hashScore.hash256(appData.getQrcodekey()));

//        docCodeRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                if (task.isSuccessful()) {
//                    Map<String, Object> data = new HashMap<>();
//                    data.put("photo", byte[]);
//                    docCodeRef.set(data, SetOptions.merge());
//                }
//            }
//        });
//
    }
}
>>>>>>> 9a3920e9eac96f05aa9194685a854bdda6297cbf
