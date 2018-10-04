package chuibiqun.share_frame_demo_zb666;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.tv_produce_bug)
    TextView tvProduceBug;
    @BindView(R.id.tv_fix_bug)
    TextView tvFixBug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.tv_produce_bug, R.id.tv_fix_bug})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_produce_bug:
                Caclutor caclutor = new Caclutor();
                caclutor.test(this);
                break;
            case R.id.tv_fix_bug:
                DexManager dexManager = new DexManager(this);
                dexManager.loadFile(new File(Environment.getExternalStorageDirectory(), "out.dex"));
                break;
        }
    }
}
