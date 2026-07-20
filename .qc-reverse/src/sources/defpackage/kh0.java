package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kh0 extends pu0 {
    public final TextView t;
    public final TextView u;
    public final ImageView v;

    public kh0(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.text_top);
        this.u = (TextView) view.findViewById(R.id.text_bottom);
        this.v = (ImageView) view.findViewById(R.id.imageView);
    }
}
