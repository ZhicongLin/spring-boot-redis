package com.example.base;

import lombok.Getter;
import lombok.Setter;
import org.apache.sanselan.ImageInfo;
import org.apache.sanselan.Sanselan;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

/**
 * Created by zc.lin on //.
 */
@Setter
@Getter
public class SetObject implements Serializable {

    private long id;
    private String name;

}
