package defpackage;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.quickcursor.App;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class y2 extends qt0 {
    public final /* synthetic */ int c = 1;
    public final List d;
    public ArrayList e;
    public final Object f;
    public final Collection g;
    public final Object h;

    public y2(z7 z7Var, List list, ArrayList arrayList, w2 w2Var) {
        this.f = z7Var;
        this.d = list;
        this.g = (List) arrayList.stream().map(new u2(0)).collect(Collectors.toList());
        this.e = new ArrayList(list);
        this.h = w2Var;
    }

    @Override // defpackage.qt0
    public final int a() {
        switch (this.c) {
        }
        return this.e.size();
    }

    @Override // defpackage.qt0
    public final void e(pu0 pu0Var, int i) {
        int i2 = this.c;
        Collection collection = this.g;
        switch (i2) {
            case 0:
                x2 x2Var = (x2) pu0Var;
                List list = (List) collection;
                p2 p2Var = (p2) this.e.get(i);
                TextView textView = x2Var.u;
                View view = x2Var.t;
                TextView textView2 = x2Var.w;
                textView.setText(p2Var.a.titleId);
                TextView textView3 = x2Var.v;
                n3 n3Var = p2Var.a;
                textView3.setText(n3Var.descriptionId);
                x2Var.x.setImageResource(n3Var.iconId);
                x2Var.a.setTag(Integer.valueOf(n3Var.valueId));
                int iJ = g1.j(n3Var);
                ImageView imageView = x2Var.y;
                imageView.setVisibility(n3Var.extraConfigs ? 0 : 8);
                if (!list.isEmpty() && !list.contains(n3Var)) {
                    textView2.setText("");
                    textView2.setVisibility(8);
                    xr.I(view, false);
                } else if (iJ != 0) {
                    String string = xr.y(iJ, 4) ? lc1.K(R.string.action_require_write_settings_permission) + "\n" : "";
                    if (xr.y(iJ, 8)) {
                        StringBuilder sbL = l11.l(string);
                        sbL.append(lc1.K(R.string.action_require_do_not_disturb_permission));
                        sbL.append("\n");
                        string = sbL.toString();
                    }
                    if (xr.y(iJ, 16)) {
                        StringBuilder sbL2 = l11.l(string);
                        sbL2.append(lc1.K(R.string.action_require_min_sdk_28));
                        sbL2.append("\n");
                        string = sbL2.toString();
                    }
                    if (xr.y(iJ, 256)) {
                        StringBuilder sbL3 = l11.l(string);
                        sbL3.append(lc1.K(R.string.action_require_min_sdk_29));
                        sbL3.append("\n");
                        string = sbL3.toString();
                    }
                    if (xr.y(iJ, 4096)) {
                        StringBuilder sbL4 = l11.l(string);
                        sbL4.append(lc1.K(R.string.action_require_min_sdk_30));
                        sbL4.append("\n");
                        string = sbL4.toString();
                    }
                    if (xr.y(iJ, 32768)) {
                        StringBuilder sbL5 = l11.l(string);
                        sbL5.append(lc1.K(R.string.action_require_min_sdk_36));
                        sbL5.append("\n");
                        string = sbL5.toString();
                    }
                    if (xr.y(iJ, 2048)) {
                        StringBuilder sbL6 = l11.l(string);
                        sbL6.append(lc1.K(R.string.action_require_min_sdk_31));
                        sbL6.append("\n");
                        string = sbL6.toString();
                    }
                    if (xr.y(iJ, 128)) {
                        StringBuilder sbL7 = l11.l(string);
                        sbL7.append(lc1.K(R.string.action_require_max_sdk_28));
                        sbL7.append("\n");
                        string = sbL7.toString();
                    }
                    if (xr.y(iJ, 32)) {
                        StringBuilder sbL8 = l11.l(string);
                        sbL8.append(lc1.K(R.string.action_require_camera_permission));
                        sbL8.append("\n");
                        string = sbL8.toString();
                    }
                    if (xr.y(iJ, 64)) {
                        StringBuilder sbL9 = l11.l(string);
                        sbL9.append(lc1.K(R.string.action_require_feature_camera_flash));
                        sbL9.append("\n");
                        string = sbL9.toString();
                    }
                    if (xr.y(iJ, 2)) {
                        StringBuilder sbL10 = l11.l(string);
                        sbL10.append(lc1.K(R.string.action_require_to_be_added));
                        sbL10.append("\n");
                        string = sbL10.toString();
                    }
                    if (xr.y(iJ, 1)) {
                        StringBuilder sbL11 = l11.l(string);
                        sbL11.append(lc1.K(R.string.action_require_trigger_mode_on_release));
                        sbL11.append("\n");
                        string = sbL11.toString();
                    }
                    if (xr.y(iJ, 512)) {
                        StringBuilder sbL12 = l11.l(string);
                        sbL12.append(lc1.K(R.string.action_require_auto_tap));
                        sbL12.append("\n");
                        string = sbL12.toString();
                    }
                    if (xr.y(iJ, 1024)) {
                        StringBuilder sbL13 = l11.l(string);
                        sbL13.append(lc1.K(R.string.action_require_system_action_warning));
                        sbL13.append("\n");
                        string = sbL13.toString();
                    }
                    if (string.length() > 0) {
                        String strSubstring = string.substring(0, string.length() - 1);
                        textView2.setVisibility(0);
                        textView2.setText(strSubstring);
                        imageView.setVisibility(8);
                    }
                } else {
                    textView2.setText("");
                    textView2.setVisibility(8);
                    xr.I(view, true);
                }
                break;
            default:
                bb bbVar = (bb) pu0Var;
                to0 to0Var = (to0) this.e.get(i);
                bbVar.t.setText(to0Var.b);
                TextView textView4 = bbVar.u;
                String str = to0Var.a;
                textView4.setText(str);
                bbVar.v.setImageDrawable(to0Var.c);
                bbVar.a.setTag(to0Var.d);
                if (((Boolean) this.f).booleanValue()) {
                    bbVar.w.setChecked(((Set) collection).contains(str));
                }
                break;
        }
    }

    @Override // defpackage.qt0
    public final pu0 f(ViewGroup viewGroup, int i) {
        switch (this.c) {
            case 0:
                final View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.action_picker_recycler_item, viewGroup, false);
                viewInflate.setOnClickListener(new View.OnClickListener() { // from class: v2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i2 = i;
                        Object obj = viewInflate;
                        y2 y2Var = (y2) this;
                        switch (i2) {
                            case 0:
                                y2Var.i((View) obj, false);
                                break;
                            case 1:
                                y2Var.i((View) obj, true);
                                break;
                            default:
                                bb bbVar = (bb) obj;
                                CheckBox checkBox = bbVar.w;
                                TextView textView = bbVar.u;
                                boolean zIsChecked = checkBox.isChecked();
                                checkBox.setChecked(!zIsChecked);
                                Set set = (Set) y2Var.g;
                                if (!zIsChecked) {
                                    set.add(textView.getText().toString());
                                } else {
                                    set.remove(textView.getText().toString());
                                }
                                break;
                        }
                    }
                });
                final int i2 = 1;
                viewInflate.findViewById(R.id.extraConfigsButton).setOnClickListener(new View.OnClickListener() { // from class: v2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i22 = i2;
                        Object obj = viewInflate;
                        y2 y2Var = (y2) this;
                        switch (i22) {
                            case 0:
                                y2Var.i((View) obj, false);
                                break;
                            case 1:
                                y2Var.i((View) obj, true);
                                break;
                            default:
                                bb bbVar = (bb) obj;
                                CheckBox checkBox = bbVar.w;
                                TextView textView = bbVar.u;
                                boolean zIsChecked = checkBox.isChecked();
                                checkBox.setChecked(!zIsChecked);
                                Set set = (Set) y2Var.g;
                                if (!zIsChecked) {
                                    set.add(textView.getText().toString());
                                } else {
                                    set.remove(textView.getText().toString());
                                }
                                break;
                        }
                    }
                });
                return new x2(viewInflate);
            default:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.app_picker_recycler_item, viewGroup, false);
                final bb bbVar = new bb(viewInflate2);
                Boolean bool = (Boolean) this.f;
                i = bool.booleanValue() ? 0 : 8;
                CheckBox checkBox = bbVar.w;
                checkBox.setVisibility(i);
                if (bool.booleanValue()) {
                    final int i3 = 2;
                    viewInflate2.setOnClickListener(new View.OnClickListener() { // from class: v2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i22 = i3;
                            Object obj = bbVar;
                            y2 y2Var = (y2) this;
                            switch (i22) {
                                case 0:
                                    y2Var.i((View) obj, false);
                                    break;
                                case 1:
                                    y2Var.i((View) obj, true);
                                    break;
                                default:
                                    bb bbVar2 = (bb) obj;
                                    CheckBox checkBox2 = bbVar2.w;
                                    TextView textView = bbVar2.u;
                                    boolean zIsChecked = checkBox2.isChecked();
                                    checkBox2.setChecked(!zIsChecked);
                                    Set set = (Set) y2Var.g;
                                    if (!zIsChecked) {
                                        set.add(textView.getText().toString());
                                    } else {
                                        set.remove(textView.getText().toString());
                                    }
                                    break;
                            }
                        }
                    });
                    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: ab
                        @Override // android.widget.CompoundButton.OnCheckedChangeListener
                        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                            Set set = (Set) this.a.g;
                            TextView textView = bbVar.u;
                            if (z) {
                                set.add(textView.getText().toString());
                            } else {
                                set.remove(textView.getText().toString());
                            }
                        }
                    });
                } else {
                    viewInflate2.setOnClickListener((va) this.h);
                }
                return bbVar;
        }
    }

    public void h(String str) {
        String[] strArrSplit = str.split(" ");
        ArrayList arrayList = this.e;
        arrayList.clear();
        for (to0 to0Var : this.d) {
            boolean z = true;
            for (String str2 : strArrSplit) {
                z = z && (to0Var.b.toLowerCase().contains(str2) || to0Var.a.contains(str2));
            }
            if (z) {
                arrayList.add(to0Var);
            }
        }
        d();
    }

    public void i(View view, boolean z) {
        Activity activity = (Activity) this.f;
        int iJ = g1.j(n3.valueOf(lc1.K(((Integer) view.getTag()).intValue())));
        int i = 4;
        if (xr.y(iJ, 4)) {
            Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
            intent.setData(Uri.parse("package:" + App.c.getPackageName()));
            activity.startActivity(intent);
            return;
        }
        if (xr.y(iJ, 8)) {
            activity.startActivity(new Intent("android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS"));
            return;
        }
        if (xr.y(iJ, 32)) {
            fc0.h(activity, new String[]{"android.permission.CAMERA"}, null, new sp1(i, this));
            return;
        }
        if (xr.y(iJ, 16) || xr.y(iJ, 256) || xr.y(iJ, 4096) || xr.y(iJ, 32768) || xr.y(iJ, 2048) || xr.y(iJ, 128) || xr.y(iJ, 64) || xr.y(iJ, 2)) {
            xr.I(view, false);
        } else {
            ((w2) this.h).g(n3.valueOf(lc1.K(((Integer) view.getTag()).intValue())), Boolean.valueOf(z));
        }
    }

    public y2(List list, boolean z, Set set, va vaVar) {
        this.d = list;
        this.f = Boolean.valueOf(z);
        this.g = set;
        this.e = new ArrayList(list);
        this.h = vaVar;
    }
}
