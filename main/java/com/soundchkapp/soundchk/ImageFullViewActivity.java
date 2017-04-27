package com.soundchkapp.soundchk;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bumptech.glide.Glide;

public class ImageFullViewActivity extends AppCompatActivity {

    Bitmap current_image = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full_view);

        final ImageView fullImgView = (ImageView) findViewById(R.id.fullImgView);
        ImageButton imageButton = (ImageButton) findViewById(R.id.button_share);



        switch (getIntent().getStringExtra("fullimg")) {

            case "griffs1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/Chess%20final.png?alt=media&token=5accd9df-1911-4cda-83f5-9f1b63c9dca7")
                        .into(fullImgView);
                current_image = fullImgView.getDrawingCache();
                break;

            case "griffs2":
                fullImgView.setBackgroundColor(Color.WHITE);
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-98ed0.appspot.com/o/head%20shot.png?alt=media&token=93d7f5f8-0cfe-4534-8dad-e32db1101266")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3511.jpg?alt=media&token=979728d1-ce96-4e68-ad24-42b4f69dd991")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "griffs5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3569.jpg?alt=media&token=1b3b7a6d-ceed-4cd9-8b8a-c39604207450")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "little1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3621.jpg?alt=media&token=de197145-89b6-4ce2-9e08-65d20b40e258")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "little2":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3679.jpg?alt=media&token=63cfb305-108e-411c-afc3-386b770fef04")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "little3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3686.jpg?alt=media&token=25029d12-79a9-48c6-90ad-4c2069190fe7")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "little4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3691.jpg?alt=media&token=193b2470-313d-40c6-9a4e-e7ac0a66c95a")
                        //.load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/1.jpg?alt=media&token=ca07e35d-4138-452b-989a-5dba30bf7638")
                        .into(fullImgView);
                break;

            case "juicy1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3728.jpg?alt=media&token=4bfae885-54cc-46e8-bffe-50784d0fa157")
                        .into(fullImgView);
                break;

            case "juicy2":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3750.jpg?alt=media&token=6b971eb0-6a1b-4215-a8cd-507b4c227534")
                        .into(fullImgView);
                break;

            case "juicy3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3777.jpg?alt=media&token=af405f11-daba-4ff2-9f36-9ee21aa17811")
                        .into(fullImgView);
                break;

            case "juicy4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3779.jpg?alt=media&token=b4bf7552-708b-4207-956f-18b7198d67af")
                        .into(fullImgView);
                break;

            case "juicy5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/_DSC3801.jpg?alt=media&token=afbe6ee2-f57b-4d1d-97b5-74907498f0c7")
                        .into(fullImgView);
                break;



            case "artawake1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%201.JPG?alt=media&token=976b967f-4135-4263-b8cc-71118839f6fc")
                        .into(fullImgView);
                break;
            case "artawake2":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/mon%20petit%20chou%202.JPG?alt=media&token=45e28631-198e-49b1-9297-15686600f86d")
                        .into(fullImgView);
                break;
            case "artawake3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%201.JPG?alt=media&token=02f1e10f-2527-4c5b-bf06-9b6dd4ddaf10")
                        .into(fullImgView);
                break;
            case "artawake4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%202.JPG?alt=media&token=edd5fe12-00ff-4845-b14b-b9a9366a0134")
                        .into(fullImgView);
                break;
            case "artawake5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/simba%20marimba%203.JPG?alt=media&token=f117879c-04c9-4176-b348-28fe7cf94d97")
                        .into(fullImgView);
                break;
            case "artawake6":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%201.JPG?alt=media&token=4484dbb6-fc49-47b1-ab7d-456a198c6595")
                        .into(fullImgView);
                break;
            case "artawake7":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%202.JPG?alt=media&token=dc12f924-2881-454e-9b03-f4b634c71972")
                        .into(fullImgView);
                break;
            case "artawake8":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/tart%20vandelay%203.JPG?alt=media&token=131fc03f-a923-425d-aadb-46941b6ce6f7")
                        .into(fullImgView);
                break;


            // Bug jar
            case "bugjar1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%201.JPG?alt=media&token=865a6b9d-afc4-4c3a-897e-7a97c373a4f4")
                        .into(fullImgView);
                break;
            case "bugjar2":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%202.JPG?alt=media&token=31d2354c-a0d2-41fb-9625-acf3c5a9e2d7")
                        .into(fullImgView);
                break;
            case "bugjar3":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%203.JPG?alt=media&token=da714dbe-8226-4a3b-8378-a6a420b0c793")
                        .into(fullImgView);
                break;
            case "bugjar4":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Hip%204.JPG?alt=media&token=b77f1943-ecc8-4369-a65a-4ebdba9f44ae")
                        .into(fullImgView);
                break;
            case "bugjar5":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%201.JPG?alt=media&token=0760c4ae-1cee-4453-8584-345f64ffc755")
                        .into(fullImgView);
                break;
            case "bugjar6":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%202.JPG?alt=media&token=77cc85e0-ca24-4a4e-aca7-3957ca4a9830")
                        .into(fullImgView);
                break;
            case "bugjar7":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%203.JPG?alt=media&token=b180f20b-e804-4d1f-b93d-ffe998a8f8d3")
                        .into(fullImgView);
                break;
            case "bugjar8":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Juicy%204.JPG?alt=media&token=547a222c-3b8e-4c6d-b559-c67a1f263385")
                        .into(fullImgView);
                break;
            case "bugjar9":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%201.JPG?alt=media&token=5d9da18f-e244-470e-9bc7-1feb7facf262")
                        .into(fullImgView);
                break;
            case "bugjar10":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%202.JPG?alt=media&token=0a8a9d5e-1708-4223-9d95-e2676b8a5fbe")
                        .into(fullImgView);
                break;
            case "bugjar11":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%203.JPG?alt=media&token=f3a524e6-d801-452f-8d8d-247deb6a6dad")
                        .into(fullImgView);
                break;
            case "bugjar12":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/bug_Saplings%204.JPG?alt=media&token=f600cde0-b3f5-46b5-89e1-0795b0db28aa")
                        .into(fullImgView);
                break;
            case "paxton1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/PAXTON.jpg?alt=media&token=c6e70cb5-5f30-43e6-9826-afdf88d93e15")
                        .into(fullImgView);
                break;
            case "rosehip1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/ROSEHIP.jpg?alt=media&token=932ba08d-7170-4aab-8b85-9476d0133dce")
                        .into(fullImgView);
                break;
            case "wagoneer1":
                Glide.with(this.getApplicationContext())
                        .load("https://firebasestorage.googleapis.com/v0/b/soundchk-8e0b6.appspot.com/o/GRAND%20WAGONEER.jpg?alt=media&token=ef743266-3978-4b84-b92c-ff392334842a")
                        .into(fullImgView);
                break;


        }

/*
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
                //String message = "Text I want to share.";
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, current_image);

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(image)
                        .setCaption("Give me my codez or I will ... you know, do that thing you don't like!")
                        .build();

                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();

                ShareApi.share(content, null);

                startActivity(Intent.createChooser(share, "Title of the dialog the system will open"));
            }
        }); */
    }
}
