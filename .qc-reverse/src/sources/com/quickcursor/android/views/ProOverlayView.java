package com.quickcursor.android.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;
import defpackage.a3;
import defpackage.zq0;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ProOverlayView extends FrameLayout {
    public static final /* synthetic */ int b = 0;

    public ProOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a() {
        if (zq0.b.c()) {
            View viewFindViewById = findViewById(R.id.overlayPro);
            if (viewFindViewById != null) {
                removeView(viewFindViewById);
                return;
            }
            return;
        }
        if (findViewById(R.id.overlayPro) == null) {
            addView(LayoutInflater.from(getContext()).inflate(R.layout.pro_overlay_layout, (ViewGroup) this, false));
            ((ExtendedFloatingActionButton) findViewById(R.id.floatingActionPro)).setOnClickListener(new a3(13, this));
        }
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (zq0.b.c()) {
            return;
        }
        a();
    }
}
