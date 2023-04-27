package com.said.execpciones;

public class StudentNotFoundException
    extends Exception
{

    public StudentNotFoundException( )
    {
        super( "Student not found!" );
    }
}
