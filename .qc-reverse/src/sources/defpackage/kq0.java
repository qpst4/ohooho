package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.SwitchPreference;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kq0 {
    public static final Class[] e = {Context.class, AttributeSet.class};
    public static final HashMap f = new HashMap();
    public final Context a;
    public final lq0 c;
    public final Object[] b = new Object[2];
    public final String[] d = {Preference.class.getPackage().getName() + ".", SwitchPreference.class.getPackage().getName() + "."};

    public kq0(Context context, lq0 lq0Var) {
        this.a = context;
        this.c = lq0Var;
    }

    public final Preference a(String str, String[] strArr, AttributeSet attributeSet) throws ClassNotFoundException {
        Class<?> cls;
        HashMap map = f;
        Constructor<?> constructor = (Constructor) map.get(str);
        if (constructor == null) {
            try {
                try {
                    ClassLoader classLoader = this.a.getClassLoader();
                    if (strArr == null || strArr.length == 0) {
                        cls = Class.forName(str, false, classLoader);
                    } else {
                        cls = null;
                        ClassNotFoundException e2 = null;
                        for (String str2 : strArr) {
                            try {
                                cls = Class.forName(str2 + str, false, classLoader);
                                break;
                            } catch (ClassNotFoundException e3) {
                                e2 = e3;
                            }
                        }
                        if (cls == null) {
                            if (e2 != null) {
                                throw e2;
                            }
                            throw new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                        }
                    }
                    constructor = cls.getConstructor(e);
                    constructor.setAccessible(true);
                    map.put(str, constructor);
                } catch (ClassNotFoundException e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
                inflateException.initCause(e5);
                throw inflateException;
            }
        }
        Object[] objArr = this.b;
        objArr[1] = attributeSet;
        return (Preference) constructor.newInstance(objArr);
    }

    public final Preference b(String str, AttributeSet attributeSet) {
        try {
            return -1 == str.indexOf(46) ? a(str, this.d, attributeSet) : a(str, null, attributeSet);
        } catch (InflateException e2) {
            throw e2;
        } catch (ClassNotFoundException e3) {
            InflateException inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class (not found)" + str);
            inflateException.initCause(e3);
            throw inflateException;
        } catch (Exception e4) {
            InflateException inflateException2 = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException2.initCause(e4);
            throw inflateException2;
        }
    }

    public final PreferenceGroup c(XmlResourceParser xmlResourceParser) {
        int next;
        PreferenceGroup preferenceGroup;
        synchronized (this.b) {
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlResourceParser);
            this.b[0] = this.a;
            do {
                try {
                    try {
                        next = xmlResourceParser.next();
                        if (next == 2) {
                            break;
                        }
                    } catch (InflateException e2) {
                        throw e2;
                    }
                } catch (IOException e3) {
                    InflateException inflateException = new InflateException(xmlResourceParser.getPositionDescription() + ": " + e3.getMessage());
                    inflateException.initCause(e3);
                    throw inflateException;
                } catch (XmlPullParserException e4) {
                    InflateException inflateException2 = new InflateException(e4.getMessage());
                    inflateException2.initCause(e4);
                    throw inflateException2;
                }
            } while (next != 1);
            if (next != 2) {
                throw new InflateException(xmlResourceParser.getPositionDescription() + ": No start tag found!");
            }
            preferenceGroup = (PreferenceGroup) b(xmlResourceParser.getName(), attributeSetAsAttributeSet);
            preferenceGroup.n(this.c);
            d(xmlResourceParser, preferenceGroup, attributeSetAsAttributeSet);
        }
        return preferenceGroup;
    }

    public final void d(XmlPullParser xmlPullParser, Preference preference, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        long jLongValue;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if ("intent".equals(name)) {
                    try {
                        preference.n = Intent.parseIntent(this.a.getResources(), xmlPullParser, attributeSet);
                    } catch (IOException e2) {
                        XmlPullParserException xmlPullParserException = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException.initCause(e2);
                        throw xmlPullParserException;
                    }
                } else if ("extra".equals(name)) {
                    this.a.getResources().parseBundleExtra("extra", attributeSet, preference.d());
                    try {
                        int depth2 = xmlPullParser.getDepth();
                        while (true) {
                            int next2 = xmlPullParser.next();
                            if (next2 == 1 || (next2 == 3 && xmlPullParser.getDepth() <= depth2)) {
                                break;
                            }
                        }
                    } catch (IOException e3) {
                        XmlPullParserException xmlPullParserException2 = new XmlPullParserException("Error parsing preference");
                        xmlPullParserException2.initCause(e3);
                        throw xmlPullParserException2;
                    }
                } else {
                    Preference preferenceB = b(name, attributeSet);
                    PreferenceGroup preferenceGroup = (PreferenceGroup) preference;
                    if (!preferenceGroup.P.contains(preferenceB)) {
                        if (preferenceB.m != null) {
                            PreferenceGroup preferenceGroup2 = preferenceGroup;
                            while (true) {
                                PreferenceGroup preferenceGroup3 = preferenceGroup2.J;
                                if (preferenceGroup3 == null) {
                                    break;
                                } else {
                                    preferenceGroup2 = preferenceGroup3;
                                }
                            }
                            String str = preferenceB.m;
                            if (preferenceGroup2.J(str) != null) {
                                Log.e("PreferenceGroup", "Found duplicated key: \"" + str + "\". This can cause unintended behaviour, please use unique keys for every preference.");
                            }
                        }
                        int i = preferenceB.h;
                        if (i == Integer.MAX_VALUE) {
                            if (preferenceGroup.Q) {
                                int i2 = preferenceGroup.R;
                                preferenceGroup.R = i2 + 1;
                                if (i2 != i) {
                                    preferenceB.h = i2;
                                    jq0 jq0Var = preferenceB.H;
                                    if (jq0Var != null) {
                                        Handler handler = jq0Var.g;
                                        nc ncVar = jq0Var.h;
                                        handler.removeCallbacks(ncVar);
                                        handler.post(ncVar);
                                    }
                                }
                            }
                            if (preferenceB instanceof PreferenceGroup) {
                                ((PreferenceGroup) preferenceB).Q = preferenceGroup.Q;
                            }
                        }
                        int iBinarySearch = Collections.binarySearch(preferenceGroup.P, preferenceB);
                        if (iBinarySearch < 0) {
                            iBinarySearch = (iBinarySearch * (-1)) - 1;
                        }
                        boolean zG = preferenceGroup.G();
                        if (preferenceB.w == zG) {
                            preferenceB.w = !zG;
                            preferenceB.l(preferenceB.G());
                            preferenceB.k();
                        }
                        synchronized (preferenceGroup) {
                            preferenceGroup.P.add(iBinarySearch, preferenceB);
                        }
                        lq0 lq0Var = preferenceGroup.c;
                        String str2 = preferenceB.m;
                        if (str2 == null || !preferenceGroup.O.containsKey(str2)) {
                            synchronized (lq0Var) {
                                jLongValue = lq0Var.b;
                                lq0Var.b = 1 + jLongValue;
                            }
                        } else {
                            jLongValue = ((Long) preferenceGroup.O.get(str2)).longValue();
                            preferenceGroup.O.remove(str2);
                        }
                        preferenceB.d = jLongValue;
                        preferenceB.e = true;
                        try {
                            preferenceB.n(lq0Var);
                            preferenceB.e = false;
                            if (preferenceB.J != null) {
                                s1.f("This preference already has a parent. You must remove the existing parent before assigning a new one.");
                                return;
                            }
                            preferenceB.J = preferenceGroup;
                            if (preferenceGroup.S) {
                                preferenceB.m();
                            }
                            jq0 jq0Var2 = preferenceGroup.H;
                            if (jq0Var2 != null) {
                                Handler handler2 = jq0Var2.g;
                                nc ncVar2 = jq0Var2.h;
                                handler2.removeCallbacks(ncVar2);
                                handler2.post(ncVar2);
                            }
                        } catch (Throwable th) {
                            preferenceB.e = false;
                            throw th;
                        }
                    }
                    d(xmlPullParser, preferenceB, attributeSet);
                }
            }
        }
    }
}
