package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l9 {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        co sp1Var;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                sp1Var = new sp1(clipData, 3);
            } else {
                eo eoVar = new eo();
                eoVar.c = clipData;
                eoVar.d = 3;
                sp1Var = eoVar;
            }
            uf1.j(textView, sp1Var.build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        co sp1Var;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            sp1Var = new sp1(clipData, 3);
        } else {
            eo eoVar = new eo();
            eoVar.c = clipData;
            eoVar.d = 3;
            sp1Var = eoVar;
        }
        uf1.j(view, sp1Var.build());
        return true;
    }
}
