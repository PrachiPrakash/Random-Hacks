from os import listdir
import numpy as np
import matplotlib.pyplot as plt

columnNumber = 1

def FnDataMatrix(fileName):
	fil = open(fileName,"r")
	fil.readline()
	global columnNumber
	
	lines = fil.readlines()
	dataFrame = np.array([line.strip().split("|") for line in lines],dtype=np.float64)
	return dataFrame[:,columnNumber]

def FnPlotData(dataFrame):
	for frame in dataFrame:
		plt.plot(frame)
	plt.show()

if __name__ == '__main__':
	OutputDir = "/Users/prakash/Test/"
	fileList = listdir(OutputDir)
	print fileList
	plotMatrix = []
	
	for name in fileList:
		plotMatrix.append(FnDataMatrix(OutputDir+name))
	
	plotMatrix = np.array(plotMatrix)
	print np.shape(plotMatrix)
	FnPlotData(plotMatrix)
	
	
