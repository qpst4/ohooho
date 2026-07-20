package com.quickcursor.android.activities;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import com.quickcursor.R;
import com.quickcursor.android.activities.WindowConfigActivity;
import com.quickcursor.android.views.ResizableView;
import defpackage.di0;
import defpackage.ey0;
import defpackage.yb0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class WindowConfigActivity extends di0 {
    public static final /* synthetic */ int C = 0;
    public ResizableView B;

    public final void F() {
        this.B.b((ey0.d / 10) * 2, ey0.e / 8, (ey0.d / 10) * 8, (ey0.e / 8) * 4);
    }

    @Override // defpackage.di0, defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_window_config);
        this.B = (ResizableView) findViewById(R.id.resizableView);
        final int i = 0;
        findViewById(R.id.button_refresh).setOnClickListener(new View.OnClickListener(this) { // from class: sh1
            public final /* synthetic */ WindowConfigActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                WindowConfigActivity windowConfigActivity = this.c;
                switch (i2) {
                    case 0:
                        int i3 = WindowConfigActivity.C;
                        windowConfigActivity.F();
                        break;
                    default:
                        int i4 = WindowConfigActivity.C;
                        Intent intent = new Intent();
                        Rect rect = windowConfigActivity.B.getRect();
                        intent.putExtra("rect", rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom);
                        windowConfigActivity.setResult(-1, intent);
                        windowConfigActivity.finish();
                        break;
                }
            }
        });
        final int i2 = 1;
        findViewById(R.id.button_done).setOnClickListener(new View.OnClickListener(this) { // from class: sh1
            public final /* synthetic */ WindowConfigActivity c;

            {
                this.c = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                WindowConfigActivity windowConfigActivity = this.c;
                switch (i22) {
                    case 0:
                        int i3 = WindowConfigActivity.C;
                        windowConfigActivity.F();
                        break;
                    default:
                        int i4 = WindowConfigActivity.C;
                        Intent intent = new Intent();
                        Rect rect = windowConfigActivity.B.getRect();
                        intent.putExtra("rect", rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom);
                        windowConfigActivity.setResult(-1, intent);
                        windowConfigActivity.finish();
                        break;
                }
            }
        });
        Rect rectG = yb0.g(getIntent().getStringExtra("rect"));
        if (rectG != null) {
            this.B.b(rectG.left, rectG.top, rectG.right, rectG.bottom);
        } else {
            F();
        }
    }
}
