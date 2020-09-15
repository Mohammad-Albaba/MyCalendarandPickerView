package com.mohammad.mycalendarandpickerview;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final int DATE_PICKER_DIALOG =0;
    public static final int TIME_PICKER_DIALOG =1;
    private  StringBuilder dateStringBuilder;
    private EditText editText;
    private boolean isDateSet =false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateStringBuilder = new StringBuilder();
        editText=findViewById(R.id.date_view);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus){
                showDialog(DATE_PICKER_DIALOG);
                    v.clearFocus();
                }
            }
        });


//        findViewById(R.id.button_pick).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               final Calendar calendar=Calendar.getInstance();
//                DatePickerDialog datePickerDialog=new DatePickerDialog(
//                        MainActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                            Calendar calendar=Calendar.getInstance();
//                            calendar.set(Calendar.YEAR, year);
//                            calendar.set(Calendar.MONTH, month);
//                            calendar.set(Calendar.DAY_OF_MONTH, day);
//                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
//                            String dateString = simpleDateFormat.format(calendar.getTime());
//                            dateStringBuilder.append(dateString);
//                            }
//                        },
//                        calendar.get(Calendar.YEAR)
//                        ,calendar.get(Calendar.MONTH)
//                        ,calendar.get(Calendar.DAY_OF_MONTH));
//                datePickerDialog.show();
//                datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                    @Override
//                    public void onDismiss(DialogInterface dialog) {
//                        Calendar calendar=Calendar.getInstance();
//                TimePickerDialog timePickerDialog=new TimePickerDialog(
//                        MainActivity.this,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
//                            Calendar calendar=Calendar.getInstance();
//                            calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                            calendar.set(Calendar.MINUTE,minute);
//                            Date selectedTime=calendar.getTime();
//                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm", Locale.getDefault());
////                            "HH:mm نظام 24 ساعة"  "hh:mm aaa نظام 12ساعة"
//                            String timeString=simpleDateFormat.format(selectedTime);
//                            dateStringBuilder.append("").append(timeString);
//                            editText.setText(dateStringBuilder.toString());
//                            }
//                        },calendar.get(Calendar.HOUR_OF_DAY),
//                        calendar.get(Calendar.MINUTE),
//                        false
//                );
//                timePickerDialog.show();
//                    }
//                });
//



//                Calendar calendar=Calendar.getInstance();
//                TimePickerDialog timePickerDialog=new TimePickerDialog(
//                        MainActivity.this,
//                        new TimePickerDialog.OnTimeSetListener() {
//                            @Override
//                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
//                            Calendar calendar=Calendar.getInstance();
//                            calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
//                            calendar.set(Calendar.MINUTE,minute);
//                            Date selectedTime=calendar.getTime();
//                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm", Locale.getDefault());
////                            "HH:mm نظام 24 ساعة"  "hh:mm aaa نظام 12ساعة"
//                            String timeString=simpleDateFormat.format(selectedTime);
//                            editText.setText(timeString);
//                            }
//                        },calendar.get(Calendar.HOUR_OF_DAY),
//                        calendar.get(Calendar.MINUTE),
//                        false
//                );
//                timePickerDialog.show();

//                Calendar calendar=Calendar.getInstance();
//                DatePickerDialog datePickerDialog=new DatePickerDialog(
//                        MainActivity.this,
//                        new DatePickerDialog.OnDateSetListener() {
//                            @Override
//                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                            Calendar calendar=Calendar.getInstance();
//                            calendar.set(Calendar.YEAR, year);
//                            calendar.set(Calendar.MONTH, month);
//                            calendar.set(Calendar.DAY_OF_MONTH, day);
//                            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
//                            String dateString = simpleDateFormat.format(calendar.getTime());
//                            editText.setText(dateString);
//                            }
//                        },
//                        calendar.get(Calendar.YEAR)
//                        ,calendar.get(Calendar.MONTH)
//                        ,calendar.get(Calendar.DAY_OF_MONTH));
//                datePickerDialog.show();
//
//            }
//        });
//        TimePicker timePicker=findViewById(R.id.time_picker);
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int hourOfDay, int minute) {
//                Calendar calendar= Calendar.getInstance();
//                calendar.set(Calendar.HOUR, hourOfDay);
//                calendar.set(Calendar.MINUTE, minute);
//                Date selectTime=calendar.getTime();
//                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm aaa", Locale.getDefault());
//                String datestring=simpleDateFormat.format(selectTime);
//                System.out.println(datestring);
//
//            }
//        });

//        DatePicker datePicker=findViewById(R.id.date_picker);
//        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {
//
//                Calendar calendar= Calendar.getInstance();
////                calendar.set(Calendar.YEAR, year);
////                calendar.set(Calendar.MONTH, month);
////                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
////                Date selectDate=calendar.getTime();
////                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
////                String datestring=simpleDateFormat.format(selectDate);
////                System.out.println(datestring);
//            }
//        });
//        CalendarView calendarView=findViewById(R.id.calendarView);
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
//                Calendar calendar= Calendar.getInstance();
//                calendar.set(Calendar.YEAR, year);
//                calendar.set(Calendar.MONTH, month);
//                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//                Date selectDate=calendar.getTime();
//                SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
//                String datestring=simpleDateFormat.format(selectDate);
//                System.out.println(datestring);
//            }
//        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        final Calendar calendar=Calendar.getInstance();

        switch (id){
            case DATE_PICKER_DIALOG:
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                calendar.set(Calendar.YEAR, year);
                                calendar.set(Calendar.MONTH, month);
                                calendar.set(Calendar.DAY_OF_MONTH, day);
                                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyy", Locale.getDefault());
                                String dateString = simpleDateFormat.format(calendar.getTime());
                                dateStringBuilder.append(dateString);
                                isDateSet =true;
                            }
                        },
                        calendar.get(Calendar.YEAR)
                        ,calendar.get(Calendar.MONTH)
                        ,calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        if (isDateSet) {
                            showDialog(TIME_PICKER_DIALOG);
                            isDateSet=false;
                        }}
                });
                return datePickerDialog;
            case TIME_PICKER_DIALOG:
                TimePickerDialog timePickerDialog=new TimePickerDialog(
                        MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                                calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                                calendar.set(Calendar.MINUTE,minute);
                                Date selectedTime=calendar.getTime();
                                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm aaa", Locale.getDefault());
//                            "HH:mm نظام 24 ساعة"  "hh:mm aaa نظام 12ساعة"
                                String timeString=simpleDateFormat.format(selectedTime);
                                dateStringBuilder.append(" ").append(timeString);
                                editText.setText(dateStringBuilder.toString());
                            }
                        },calendar.get(Calendar.HOUR),
                        calendar.get(Calendar.MINUTE),
                        false
                );
                return timePickerDialog;

        }
        return super.onCreateDialog(id);
    }

    @Override
    protected void onPause() {
        super.onPause();
        isDateSet=false;
    }
}