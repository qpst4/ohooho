package defpackage;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y3 extends pu0 {
    public final TextView t;
    public final ImageView u;
    public final AppCompatImageView v;
    public final AppCompatImageView w;

    public y3(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.title);
        this.u = (ImageView) view.findViewById(R.id.icon);
        this.v = (AppCompatImageView) view.findViewById(com.quickcursor.R.id.drag_handler);
        this.w = (AppCompatImageView) view.findViewById(com.quickcursor.R.id.settings);
    }
}
