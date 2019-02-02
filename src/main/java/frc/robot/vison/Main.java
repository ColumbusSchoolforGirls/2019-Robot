/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
/* 
package frc.robot.vison;

import edu.wpi.cscore.HttpCamera;
import edu.wpi.cscore.MjpegServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.*;
import edu.wpi.cscore.*;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.*;
import org.opencv.core.Core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.*;
import org.opencv.objdetect.*;


/**
 * Add your docs here.
 */
/*public class Main {
    public static void main (String args) {
        // Loads our OpenCV library. This MUST be included
        system.loadLibrary("opencv_java310");

        //Connect NetworkTables, and get access to the publishing table
        NetworkTable.setClientMode();
        NetworkTable.setTeam(677);

        NetworkTable.initialize();

        //This is the network port you want to stram the raw reveived image to
        //By rules, this has to be between 1180 and 1190, so 1185 is a good choice
        int streamPort = 1185;

        //This stores our refer3ence to our mjpeg server for streaming the input image
        MjpegServer inputStream = new MjpegServer("MJPEG Server", streamPort);

        //USB Camera

        //This gets the image from a USB camera
        //Usually this will be on device 0, but there are other overloads that can be used
        UsbCamera camera = setUsbCamera(0, inputStream);
        //Set resolution for our camera
        //This was the resolution and exposure from Chief Delphi, so it may need to be changed for our camera
        camera.setResolution(640, 480);
        camera.setExposureManual(0);

        GripPipeline pipeline = new GripPipeline();

        //This creabes a CvSink for us to use. This grabs images from our selected camera,
        //and will allow us to use those images in opencv

        CvSink imageSink = new CvSink("CV Image Grabber");
        imageSink.setSource(camera);

        //This creates a CvSource to use. This will take in a Mat image that has had OpenCV operations
        CvSource imageSource = new CvSource("CV IMage Source", VideoMode.PixelFormat.kMJPEG, 640, 480, 30);
        MjpegServer cvStream = new MjpegServer("CV Image Stream", 1186);
        cvStream.setSource(imageSource);

        //All Mats and Lists should be stored outside the loop to avoid allocation
        //as they are expensive to create
        Mat inputImage = new Mat();
        Mat hsv = new Mat(); 

        NetworkTable targets = NetworkTable.getTable("GRIP/targets");

        // Infinitely process image
        while (true) {
            //Grab a frame. If it has a frame time of 0, there was anerror.
            //Just skip and continue
            long frameTime = imageSink.grabFrame(inputImage);
            if (frameTime == 0) continue;
        }

        /* Below is where you would do your OpenCV operations on the provided image
        The sample below just canges color source to HSV*/
        //Imgproc.cvtColor(inputImage, hsv, Imgproc.Color_BGR2HSV);

        /* Here is where you would write a processsed image that you want to restreams 
        This will mot likely be a marked up image of what the camera sees
        For now, we are just going to stream the HSV image*/
        /*pipeline.process(inputImage);

        String point = pipeline.findContoursOutput().toString();

        targets.putString("test", point);

        imageSource.putFrame(inputImage);

    }

private static UsbCamera setUsbCamera (int cameraId, MjpegServer server) {
    //This gets the image from a USB camera
    //Usually this will be on device 0, but there are other overloads that can be used
    UsbCamera camera = new UsbCamera("CoprocessorCamera", cameraId);
    server.setSource(camera);
    return camera;
    }
}    
*/