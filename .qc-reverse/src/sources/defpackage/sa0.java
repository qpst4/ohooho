package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.github.dhaval2404.imagepicker.ImagePickerActivity;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sa0 {
    public ta0 a;
    public String[] b;
    public int c;
    public int d;
    public long e;
    public final z7 f;

    public sa0(j30 j30Var) {
        j30Var.getClass();
        this.f = j30Var.Z();
        this.a = ta0.d;
        this.b = new String[0];
    }

    public final Intent a() {
        Intent intent = new Intent(this.f, (Class<?>) ImagePickerActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra.image_provider", this.a);
        bundle.putStringArray("extra.mime_types", this.b);
        bundle.putBoolean("extra.crop", false);
        bundle.putFloat("extra.crop_x", 0.0f);
        bundle.putFloat("extra.crop_y", 0.0f);
        bundle.putInt("extra.max_width", this.c);
        bundle.putInt("extra.max_height", this.d);
        bundle.putLong("extra.image_max_size", this.e);
        bundle.putString("extra.save_directory", null);
        intent.putExtras(bundle);
        return intent;
    }

    public final void b(v40 v40Var) {
        if (this.a != ta0.d) {
            v40Var.g(a());
            return;
        }
        i9 i9Var = new i9(this, v40Var, 22, false);
        z7 z7Var = this.f;
        z7Var.getClass();
        View viewInflate = LayoutInflater.from(z7Var).inflate(R.layout.dialog_choose_app, (ViewGroup) null);
        jl1 jl1Var = new jl1(z7Var);
        x6 x6Var = (x6) jl1Var.c;
        jl1Var.m(R.string.title_choose_image_provider);
        x6Var.u = viewInflate;
        x6Var.o = new yt();
        jl1Var.h(R.string.action_cancel, new zt());
        x6Var.p = new au();
        b7 b7VarN = jl1Var.n();
        viewInflate.findViewById(R.id.lytCameraPick).setOnClickListener(new xt(i9Var, b7VarN, 0));
        viewInflate.findViewById(R.id.lytGalleryPick).setOnClickListener(new xt(i9Var, b7VarN, 1));
    }
}
