import cv2
import numpy as np

class FitnessFunction:
    def __init__(self, imgOrig):
        self.imgOrig = imgOrig

    
    def evaluate(self, cromosoma):
        imgIntento = cromosoma.getImagenGen()
        
        diferencia = cv2.absdiff(imgIntento, self.imgOrig)

        sumaDiferencias = np.sum(diferencia, axis=0)
        sumaPlanos = sum(sumaDiferencias)
 
        return sumaPlanos

    
