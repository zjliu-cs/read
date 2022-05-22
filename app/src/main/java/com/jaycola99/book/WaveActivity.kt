package com.jaycola99.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jaycola99.book.widget.WaveView

class WaveActivity : AppCompatActivity() {
    private var isPlaying = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wave)
        val waveView = findViewById<WaveView>(R.id.wv_wave)
        val btn = findViewById<Button>(R.id.btn_start)
        btn.setOnClickListener {
            if (!isPlaying) {
                waveView.startAnim()
            } else {
                waveView.stopAnim()
            }
            isPlaying = !isPlaying
            btn.text = if (isPlaying) "停止播放动画" else "开始播放动画"
        }
    }
}