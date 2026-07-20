package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class v01 extends gp0 {
    public TextView Z = null;
    public TextView a0 = null;
    public ImageView b0 = null;

    @Override // defpackage.j30
    public final void J(Bundle bundle) {
        super.J(bundle);
        f40 f40Var = g40.a;
        g40.b(new c40(this, "Attempting to set retain instance for fragment " + this));
        g40.a(this).getClass();
        this.C = true;
        y30 y30Var = this.t;
        if (y30Var != null) {
            y30Var.L.c(this);
        } else {
            this.D = true;
        }
        h0();
    }

    @Override // defpackage.j30
    public final View K(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int color;
        int color2;
        Bundle bundle = this.h;
        View viewInflate = layoutInflater.inflate(bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_LAYOUT_RES", R.layout.mi_fragment_simple_slide), viewGroup, false);
        this.Z = (TextView) viewInflate.findViewById(R.id.mi_title);
        this.a0 = (TextView) viewInflate.findViewById(R.id.mi_description);
        this.b0 = (ImageView) viewInflate.findViewById(R.id.mi_image);
        bundle.getLong("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_ID");
        CharSequence charSequence = bundle.getCharSequence("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_TITLE");
        int i = bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_TITLE_RES");
        CharSequence charSequence2 = bundle.getCharSequence("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_DESCRIPTION");
        int i2 = bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_DESCRIPTION_RES");
        int i3 = bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_IMAGE_RES");
        int i4 = bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_BACKGROUND_RES");
        TextView textView = this.Z;
        if (textView != null) {
            if (charSequence != null) {
                textView.setText(charSequence);
                this.Z.setVisibility(0);
            } else if (i != 0) {
                textView.setText(i);
                this.Z.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = this.a0;
        if (textView2 != null) {
            if (charSequence2 != null) {
                textView2.setText(charSequence2);
                this.a0.setVisibility(0);
            } else if (i2 != 0) {
                textView2.setText(i2);
                this.a0.setVisibility(0);
            } else {
                textView2.setVisibility(8);
            }
        }
        ImageView imageView = this.b0;
        if (imageView != null) {
            if (i3 != 0) {
                try {
                    imageView.setImageResource(i3);
                } catch (OutOfMemoryError unused) {
                    this.b0.setVisibility(8);
                }
                this.b0.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        if (i4 == 0 || wl.c(u().getColor(i4)) >= 0.6d) {
            color = u().getColor(R.color.mi_text_color_primary_light);
            color2 = u().getColor(R.color.mi_text_color_secondary_light);
        } else {
            color = u().getColor(R.color.mi_text_color_primary_dark);
            color2 = u().getColor(R.color.mi_text_color_secondary_dark);
        }
        TextView textView3 = this.Z;
        if (textView3 != null) {
            textView3.setTextColor(color);
        }
        TextView textView4 = this.a0;
        if (textView4 != null) {
            textView4.setTextColor(color2);
        }
        return viewInflate;
    }

    @Override // defpackage.j30
    public final void M() {
        this.Z = null;
        this.a0 = null;
        this.b0 = null;
        this.F = true;
    }

    @Override // defpackage.j30
    public final void Q(int i, String[] strArr, int[] iArr) {
        Bundle bundle = this.h;
        if (i == (bundle != null ? bundle.getInt("com.heinrichreimersoftware.materialintro.SimpleFragment.ARGUMENT_PERMISSIONS_REQUEST_CODE", 34) : 34)) {
            h0();
        }
    }

    @Override // defpackage.j30
    public final void R() {
        this.F = true;
        h0();
    }
}
