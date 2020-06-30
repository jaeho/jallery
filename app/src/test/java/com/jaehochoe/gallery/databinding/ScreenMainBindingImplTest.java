package com.jaehochoe.gallery.databinding;

import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.mrt.nasca.NascaView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by jaehochoe on 2020/06/29.
 */
@RunWith(JUnit4.class)
public class ScreenMainBindingImplTest {

    ScreenMainBindingImpl binding = mock(ScreenMainBindingImpl.class);

    @Before
    public void setUp() throws Exception {
        Field f = ScreenMainBinding.class.getDeclaredField("nasca");
        f.setAccessible(true);
        f.set(binding, mock(NascaView.class));

        f = ScreenMainBinding.class.getDeclaredField("spinner");
        f.setAccessible(true);
        f.set(binding, mock(Spinner.class));

        f = ScreenMainBinding.class.getDeclaredField("progress");
        f.setAccessible(true);
        f.set(binding, mock(ProgressBar.class));

        f = ScreenMainBinding.class.getDeclaredField("retry");
        f.setAccessible(true);
        f.set(binding, mock(Button.class));

        f = ScreenMainBinding.class.getDeclaredField("label");
        f.setAccessible(true);
        f.set(binding, mock(TextView.class));
    }

    @Test
    public void setOnErrorOnProgressFalseWithNasca() throws Exception {
        when(binding.getOnError()).thenReturn(false); // binding.setOnError(false);
        when(binding.getOnProgress()).thenReturn(false); // binding.setOnError(false);
        int visible = !binding.getOnError() && !binding.getOnProgress() ? View.VISIBLE : View.GONE;
        when(binding.nasca.getVisibility()).thenReturn(visible);
        assertEquals(binding.nasca.getVisibility(), View.VISIBLE);
    }

    @Test
    public void setOnErrorOnProgressTrueWithNasca() throws Exception {
        when(binding.getOnError()).thenReturn(true); // binding.setOnError(true);
        when(binding.getOnProgress()).thenReturn(true); // binding.setOnProgress(true);
        int visible = !binding.getOnError() && !binding.getOnProgress() ? View.VISIBLE : View.GONE;
        when(binding.nasca.getVisibility()).thenReturn(visible);
        assertEquals(binding.nasca.getVisibility(), View.GONE);
    }

    @Test
    public void setOnProgressTrueWithSpinner() throws Exception {
        when(binding.getOnProgress()).thenReturn(true); // binding.setOnProgress(true);
        int visible = !binding.getOnProgress() ? View.VISIBLE : View.GONE;
        when(binding.spinner.getVisibility()).thenReturn(visible);
        assertEquals(binding.spinner.getVisibility(), View.GONE);
    }

    @Test
    public void setOnProgressTrueWithProgress() throws Exception {
        when(binding.getOnProgress()).thenReturn(true); // binding.setOnProgress(true);
        int visible = binding.getOnProgress() ? View.VISIBLE : View.GONE;
        when(binding.progress.getVisibility()).thenReturn(visible);
        assertEquals(binding.progress.getVisibility(), View.VISIBLE);
    }

    @Test
    public void setOnProgressTrueWithRetry() throws Exception {
        when(binding.getOnError()).thenReturn(true); // binding.setOnError(true);
        int visible = binding.getOnError() ? View.VISIBLE : View.GONE;
        when(binding.retry.getVisibility()).thenReturn(visible);
        when(binding.label.getVisibility()).thenReturn(visible);
        assertEquals(binding.retry.getVisibility(), View.VISIBLE);
        assertEquals(binding.label.getVisibility(), View.VISIBLE);
    }
}