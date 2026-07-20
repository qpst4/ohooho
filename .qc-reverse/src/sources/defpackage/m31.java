package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m31 extends MenuInflater {
    public static final Class[] e;
    public static final Class[] f;
    public final Object[] a;
    public final Object[] b;
    public final Context c;
    public Object d;

    static {
        Class[] clsArr = {Context.class};
        e = clsArr;
        f = clsArr;
    }

    public m31(Context context) {
        super(context);
        this.c = context;
        Object[] objArr = {context};
        this.a = objArr;
        this.b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    public final void b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        int i;
        XmlPullParser xmlPullParser2;
        ColorStateList colorStateList;
        l31 l31Var = new l31(this, menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            i = 2;
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlPullParser.next();
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType == 1) {
                throw new RuntimeException("Unexpected end of document");
            }
            Menu menu2 = l31Var.a;
            if (eventType != i) {
                if (eventType != 3) {
                    xmlPullParser2 = xmlPullParser;
                    z = z;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (z2 && name2.equals(str)) {
                        xmlPullParser2 = xmlPullParser;
                        z2 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            l31Var.b = 0;
                            l31Var.c = 0;
                            l31Var.d = 0;
                            l31Var.e = 0;
                            l31Var.f = true;
                            l31Var.g = true;
                        } else if (name2.equals("item")) {
                            if (!l31Var.h) {
                                dl0 dl0Var = l31Var.z;
                                if (dl0Var == null || !dl0Var.b.hasSubMenu()) {
                                    l31Var.h = true;
                                    l31Var.b(menu2.add(l31Var.b, l31Var.i, l31Var.j, l31Var.k));
                                } else {
                                    l31Var.h = true;
                                    l31Var.b(menu2.addSubMenu(l31Var.b, l31Var.i, l31Var.j, l31Var.k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            xmlPullParser2 = xmlPullParser;
                            z = true;
                        }
                        xmlPullParser2 = xmlPullParser;
                        z = z;
                    }
                }
                eventType = xmlPullParser2.next();
                i = 2;
                z = z;
                z2 = z2;
            } else {
                if (!z2) {
                    String name3 = xmlPullParser.getName();
                    boolean zEquals = name3.equals("group");
                    Context context = this.c;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.p);
                        l31Var.b = typedArrayObtainStyledAttributes.getResourceId(1, 0);
                        l31Var.c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        l31Var.d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        l31Var.e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        l31Var.f = typedArrayObtainStyledAttributes.getBoolean(2, true);
                        l31Var.g = typedArrayObtainStyledAttributes.getBoolean(0, true);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            ra raVarL = ra.L(context, attributeSet, zs0.q);
                            TypedArray typedArray = (TypedArray) raVarL.c;
                            l31Var.i = typedArray.getResourceId(2, 0);
                            l31Var.j = (typedArray.getInt(6, l31Var.d) & 65535) | (typedArray.getInt(5, l31Var.c) & (-65536));
                            l31Var.k = typedArray.getText(7);
                            l31Var.l = typedArray.getText(8);
                            l31Var.m = typedArray.getResourceId(0, 0);
                            String string = typedArray.getString(9);
                            l31Var.n = string == null ? (char) 0 : string.charAt(0);
                            l31Var.o = typedArray.getInt(16, 4096);
                            String string2 = typedArray.getString(10);
                            l31Var.p = string2 == null ? (char) 0 : string2.charAt(0);
                            l31Var.q = typedArray.getInt(20, 4096);
                            if (typedArray.hasValue(11)) {
                                l31Var.r = typedArray.getBoolean(11, false) ? 1 : 0;
                            } else {
                                l31Var.r = l31Var.e;
                            }
                            l31Var.s = typedArray.getBoolean(3, false);
                            l31Var.t = typedArray.getBoolean(4, l31Var.f);
                            l31Var.u = typedArray.getBoolean(1, l31Var.g);
                            l31Var.v = typedArray.getInt(21, -1);
                            l31Var.y = typedArray.getString(12);
                            l31Var.w = typedArray.getResourceId(13, 0);
                            l31Var.x = typedArray.getString(15);
                            String string3 = typedArray.getString(14);
                            boolean z3 = string3 != null;
                            if (z3 && l31Var.w == 0 && l31Var.x == null) {
                                l31Var.z = (dl0) l31Var.a(string3, f, this.b);
                            } else {
                                if (z3) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                l31Var.z = null;
                            }
                            l31Var.A = typedArray.getText(17);
                            l31Var.B = typedArray.getText(22);
                            if (typedArray.hasValue(19)) {
                                l31Var.D = vu.c(typedArray.getInt(19, -1), l31Var.D);
                                colorStateList = null;
                            } else {
                                colorStateList = null;
                                l31Var.D = null;
                            }
                            if (typedArray.hasValue(18)) {
                                l31Var.C = raVarL.x(18);
                            } else {
                                l31Var.C = colorStateList;
                            }
                            raVarL.O();
                            l31Var.h = false;
                            xmlPullParser2 = xmlPullParser;
                        } else if (name3.equals("menu")) {
                            l31Var.h = true;
                            SubMenu subMenuAddSubMenu = menu2.addSubMenu(l31Var.b, l31Var.i, l31Var.j, l31Var.k);
                            l31Var.b(subMenuAddSubMenu.getItem());
                            xmlPullParser2 = xmlPullParser;
                            b(xmlPullParser2, attributeSet, subMenuAddSubMenu);
                        } else {
                            xmlPullParser2 = xmlPullParser;
                            str = name3;
                            z2 = true;
                        }
                        eventType = xmlPullParser2.next();
                        i = 2;
                        z = z;
                        z2 = z2;
                    }
                }
                xmlPullParser2 = xmlPullParser;
                z = z;
            }
            eventType = xmlPullParser2.next();
            i = 2;
            z = z;
            z2 = z2;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i, Menu menu) {
        if (!(menu instanceof zk0)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser layout = null;
        boolean z = false;
        try {
            try {
                layout = this.c.getResources().getLayout(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(layout);
                if (menu instanceof zk0) {
                    zk0 zk0Var = (zk0) menu;
                    if (!zk0Var.p) {
                        zk0Var.w();
                        z = true;
                    }
                }
                b(layout, attributeSetAsAttributeSet, menu);
                if (z) {
                    ((zk0) menu).v();
                }
                layout.close();
            } catch (IOException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (XmlPullParserException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (z) {
                ((zk0) menu).v();
            }
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
