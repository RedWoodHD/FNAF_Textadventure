package Game.factory;

import Game.factor.CameraName;
import Game.factor.RoomName;
import Game.object.Camera;
import Game.object.Room;
import Game.text_message.RoomDescription;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse representiert eine Kamera Fabrik um alle {@link Camera}'s zu erstellen.<br>
 * Dafür wird die Methode {@link #createAllCameras()} genutzt.<br>
 * Sie hat Zugriff auf Zwei {@link HashMap}'s mit allen {@link Camera}'s<br>
 * Sie hat Zugriff auf Zwei {@link HashMap}'s mit allen  {@link Room}'s
 * @author EGA
 */

public class CameraFactory
{
    private final Map<RoomName, Room> allRooms;
    private final Map<CameraName,Camera> allCameras;

    public CameraFactory(Map<RoomName, Room> allRooms)
    {
        this.allRooms = allRooms;
        this.allCameras = createAllCameras();
    }

    /**
     *Diese Methode erstellt alle {@link Camera Cameras} mit ihren dazugehörigen {@link Camera#connectedCameras verbundenen} {@link Camera Cameras}.<br>
     *Die {@link Camera Kamera}'s kennen ihre {@link Room Räume}.
     * @return  Eine {@link Map allCamerasMap} {@code key:} {@link CameraName}   {@code value:} {@link Camera}
     */
    private Map<CameraName, Camera> createAllCameras(){
        Map<CameraName, Camera> allCamerasMap = new HashMap<>();
//        Erstelle jede Camera
        Camera cam1A = new Camera(CameraName.CAM1A);
        Camera cam1B = new Camera(CameraName.CAM1B);
        Camera cam1C = new Camera(CameraName.CAM1C);
        Camera cam2A = new Camera(CameraName.CAM2A);
        Camera cam2B = new Camera(CameraName.CAM2B);
        Camera cam3 = new Camera(CameraName.CAM3);
        Camera cam4A = new Camera(CameraName.CAM4A);
        Camera cam4B = new Camera(CameraName.CAM4B);
        Camera cam5 = new Camera(CameraName.CAM5);
        Camera cam6 = new Camera(CameraName.CAM6);
        Camera cam7 = new Camera(CameraName.CAM7);
        Camera freeCam = new Camera(CameraName.FREECAM);

//        Übergebe jeder Kamera ihren Raum
        cam1A.setWhatRoomDoILookAt(allRooms.get(RoomName.SHOWSTAGE));
        cam1B.setWhatRoomDoILookAt(allRooms.get(RoomName.DININGAREA));
        cam1C.setWhatRoomDoILookAt(allRooms.get(RoomName.PIRATECOVE));
        cam2A.setWhatRoomDoILookAt(allRooms.get(RoomName.WESTHALL));
        cam2B.setWhatRoomDoILookAt(allRooms.get(RoomName.WESTHALLCORNER));
        cam3.setWhatRoomDoILookAt(allRooms.get(RoomName.SUPPLYCLOSET));
        cam4A.setWhatRoomDoILookAt(allRooms.get(RoomName.EASTHALL));
        cam4B.setWhatRoomDoILookAt(allRooms.get(RoomName.EASTHALLCORNER));
        cam5.setWhatRoomDoILookAt(allRooms.get(RoomName.BACKSTAGE));
        cam6.setWhatRoomDoILookAt(allRooms.get(RoomName.KITCHEN));
        cam7.setWhatRoomDoILookAt(allRooms.get(RoomName.RESTROOMS));

//        Übergebe jeder Kamera ihre description.
        cam1A.setDescription(RoomDescription.showStage);
        cam1B.setDescription(RoomDescription.diningArea);
        cam1C.setDescription(RoomDescription.pirateCove);
        cam2A.setDescription(RoomDescription.westHall);
        cam2B.setDescription(RoomDescription.westHallCorner);
        cam3.setDescription(RoomDescription.supplyCloset);
        cam4A.setDescription(RoomDescription.eastHall);
        cam4B.setDescription(RoomDescription.eastHallCorner);
        cam5.setDescription(RoomDescription.backstage);
        cam6.setDescription(RoomDescription.kitchen);
        cam7.setDescription(RoomDescription.restrooms);

//        Gebe jeder Camera ihre verbundenen Cameras als Liste mit.
        List<Camera> wiresCam1A = new ArrayList<>();
        wiresCam1A.add(cam1B);
        wiresCam1A.add(cam1C);
        wiresCam1A.add(cam7);
        cam1A.setConnectedCameras(wiresCam1A);

        List<Camera> wiresCam1B = new ArrayList<>();
        wiresCam1B.add(cam1C);
        wiresCam1B.add(cam1A);
        wiresCam1B.add(cam7);
        wiresCam1B.add(cam5);
        cam1B.setConnectedCameras(wiresCam1B);

        List<Camera> wiresCam1C = new ArrayList<>();
        wiresCam1C.add(cam1A);
        wiresCam1C.add(cam1B);
        wiresCam1C.add(cam2A);
        cam1C.setConnectedCameras(wiresCam1C);

        List<Camera> wiresCam5 = new ArrayList<>();
        wiresCam5.add(cam1B);
        wiresCam5.add(cam1C);
        cam5.setConnectedCameras(wiresCam5);

        List<Camera> wiresCam7 = new ArrayList<>();
        wiresCam7.add(cam6);
        wiresCam7.add(cam1C);
        cam7.setConnectedCameras(wiresCam7);

        List<Camera> wiresCam6 = new ArrayList<>();
        wiresCam7.add(cam1C);
        wiresCam7.add(cam4A);
        cam6.setConnectedCameras(wiresCam6);

        List<Camera> wiresCam4A = new ArrayList<>();
        wiresCam4A.add(cam4B);
        wiresCam4A.add(cam1C);
        wiresCam4A.add(cam6);
        cam4A.setConnectedCameras(wiresCam4A);

        List<Camera> wiresCam4B = new ArrayList<>();
        wiresCam4B.add(cam4A);
        wiresCam4B.add(cam2B);
        cam4B.setConnectedCameras(wiresCam4B);

        List<Camera> wiresCam2A = new ArrayList<>();
        wiresCam2A.add(cam3);
        wiresCam2A.add(cam2B);
        cam2A.setConnectedCameras(wiresCam2A);

        List<Camera> wiresCam2B = new ArrayList<>();
        wiresCam2B.add(cam2A);
        wiresCam2B.add(cam3);
        cam2B.setConnectedCameras(wiresCam2B);

        List<Camera> wiresCam3 = new ArrayList<>();
        wiresCam3.add(cam2A);
        wiresCam3.add(cam1C);
        cam3.setConnectedCameras(wiresCam3);

        List<Camera> wiresFreeCam = new ArrayList<>();
        wiresFreeCam.add(cam1A);
        wiresFreeCam.add(cam1B);
        wiresFreeCam.add(cam1C);
        wiresFreeCam.add(cam2A);
        wiresFreeCam.add(cam2B);
        wiresFreeCam.add(cam3);
        wiresFreeCam.add(cam4A);
        wiresFreeCam.add(cam4B);
        wiresFreeCam.add(cam5);
        wiresFreeCam.add(cam6);
        wiresFreeCam.add(cam7);
        freeCam.setConnectedCameras(wiresFreeCam);

//        Alle Cameras werden den Map hinzugefügt mit Camera Namen.
        allCamerasMap.put(CameraName.CAM1A,cam1A);
        allCamerasMap.put(CameraName.CAM1B,cam1B);
        allCamerasMap.put(CameraName.CAM1C,cam1C);
        allCamerasMap.put(CameraName.CAM2A,cam2A);
        allCamerasMap.put(CameraName.CAM2B,cam2B);
        allCamerasMap.put(CameraName.CAM3,cam3);
        allCamerasMap.put(CameraName.CAM4A,cam4A);
        allCamerasMap.put(CameraName.CAM4B,cam4B);
        allCamerasMap.put(CameraName.CAM5,cam5);
        allCamerasMap.put(CameraName.CAM6,cam6);
        allCamerasMap.put(CameraName.CAM7,cam7);
        allCamerasMap.put(CameraName.FREECAM,freeCam);

        return allCamerasMap;
    }

    public Map<CameraName, Camera> getAllCameras()
    {
        return allCameras;
    }
}
