package com.example.multimedia;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configuración de insets para la vista principal
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
    }
}
