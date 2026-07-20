package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x2 extends pu0 {
    public final View t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final ImageView x;
    public final ImageView y;

    public x2(View view) {
        super(view);
        this.t = view;
        this.u = (TextView) view.findViewById(R.id.text_top);
        this.v = (TextView) view.findViewById(R.id.text_bottom);
        this.w = (TextView) view.findViewById(R.id.text_requirements);
        this.x = (ImageView) view.findViewById(R.id.imageView);
        this.y = (ImageView) view.findViewById(R.id.extraConfigsButton);
    }
}
