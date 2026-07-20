package defpackage;

import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.b;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class er {
    public final TextView a;
    public final ImageView b;
    public final ImageView c;
    public final AbsoluteLayout.LayoutParams d;
    public int e;
    public int f;
    public float g;
    public float h;

    public er(z7 z7Var, Bitmap bitmap, Pair pair, b bVar) {
        View viewInflate = z7Var.getLayoutInflater().inflate(R.layout.dialog_point_on_image_position, (ViewGroup) null);
        this.a = (TextView) viewInflate.findViewById(R.id.text_view);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.cursor_image_view);
        this.b = imageView;
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.crosshair_image_view);
        this.c = imageView2;
        imageView.setMaxHeight(ey0.b() / 3);
        imageView.setImageBitmap(bitmap);
        this.d = (AbsoluteLayout.LayoutParams) imageView2.getLayoutParams();
        imageView.setOnTouchListener(new cr(0, this));
        jl1 jl1Var = new jl1(z7Var);
        jl1Var.m(R.string.cursor_settings_tip_position_dialog_title);
        x6 x6Var = (x6) jl1Var.c;
        x6Var.u = viewInflate;
        jl1Var.k(R.string.dialog_button_done, new pd(this, 1, bVar));
        jl1Var.h(R.string.dialog_button_cancel, new g2(bVar));
        x6Var.o = new dr();
        jl1Var.c().show();
        b61.b(new k2(this, 11, pair), 1L);
    }

    public final void a(float f, float f2) {
        this.g = f;
        this.h = f2;
        ImageView imageView = this.c;
        int width = imageView.getWidth() / 2;
        int height = imageView.getHeight() / 2;
        AbsoluteLayout.LayoutParams layoutParams = this.d;
        layoutParams.x = (int) ((this.e * f) - width);
        layoutParams.y = (int) ((this.f * f2) - height);
        imageView.setLayoutParams(layoutParams);
        StringBuilder sb = new StringBuilder();
        sb.append(lc1.K(R.string.cursor_settings_tip_position_dialog_coordinates_text));
        sb.append(" X: ");
        sb.append(Math.round(((double) (f * 100.0f)) * r8) / ((int) Math.pow(10.0d, 1.0d)));
        sb.append("%, Y: ");
        sb.append(Math.round(((double) (f2 * 100.0f)) * r1) / ((int) Math.pow(10.0d, 1.0d)));
        sb.append("%");
        this.a.setText(sb.toString());
    }
}
