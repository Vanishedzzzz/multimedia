package com.example.multimedia;

<<<<<<< HEAD
import android.Manifest;
import android.content.pm.PackageManager;
=======
>>>>>>> a001e4ab048da5250d8d93f2bbf4a04afa42195f
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
<<<<<<< HEAD
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
=======

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
>>>>>>> a001e4ab048da5250d8d93f2bbf4a04afa42195f
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    private static final int REQUEST_PERMISSION_READ_EXTERNAL_STORAGE = 1;
    private MediaPlayer mediaPlayer;
    private VideoView videoView;
=======
>>>>>>> a001e4ab048da5250d8d93f2bbf4a04afa42195f

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

<<<<<<< HEAD
=======
        // Configuración de insets para la vista principal
>>>>>>> a001e4ab048da5250d8d93f2bbf4a04afa42195f
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

<<<<<<< HEAD
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION_READ_EXTERNAL_STORAGE);
        }

        Button playAudioButton = findViewById(R.id.button);
        playAudioButton.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = false;

            @Override
            public void onClick(View v) {
                if (isPlaying) {
                    mediaPlayer.pause();
                    playAudioButton.setText("Reproducir audio");
                } else {
                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.zundada);
                    mediaPlayer.start();
                    playAudioButton.setText("Pausar audio");
                    mediaPlayer.setOnCompletionListener(mp -> {
                        mp.release();
                        playAudioButton.setText("Reproducir audio");
                        isPlaying = false;
                    });
                }
                isPlaying = !isPlaying;
            }
        });

        videoView = findViewById(R.id.videoView);
        Button playVideoButton = findViewById(R.id.button2);
        playVideoButton.setOnClickListener(new View.OnClickListener() {
            boolean isVideoPlaying = false;

            @Override
            public void onClick(View v) {
                if (isVideoPlaying) {
                    videoView.pause();
                    playVideoButton.setText("Reproducir video");
                } else {
                    Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.paloma);
                    videoView.setVideoURI(videoUri);
                    videoView.start();
                    playVideoButton.setText("Pausar video");
                }
                isVideoPlaying = !isVideoPlaying;
            }
        });

        Button animateButton = findViewById(R.id.botonanimar);
        animateButton.setOnClickListener(v -> {
            View myImageView = findViewById(R.id.myImageView);
            myImageView.setVisibility(View.VISIBLE);
            myImageView.startAnimation(android.view.animation.AnimationUtils.loadAnimation(this, R.anim.fade_in));
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_PERMISSION_READ_EXTERNAL_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso concedido
            } else {
                // Permiso denegado
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
=======
        // Encuentra el botón para reproducir audio
        Button playAudioButton = findViewById(R.id.button);
        playAudioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.zundada);
                mediaPlayer.start();

                // Libera los recursos cuando termine de reproducir
                mediaPlayer.setOnCompletionListener(mp -> mp.release());
            }
        });

        // Encuentra el VideoView y el botón para reproducir video
        VideoView videoView = findViewById(R.id.videoView);
        Button playVideoButton = findViewById(R.id.button2);

        // Establece el OnClickListener para el botón de video
        playVideoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.paloma); // Cambia tu_video por el nombre de tu archivo
                videoView.setVideoURI(videoUri);
                videoView.start();
            }
        });
>>>>>>> a001e4ab048da5250d8d93f2bbf4a04afa42195f
    }
}
