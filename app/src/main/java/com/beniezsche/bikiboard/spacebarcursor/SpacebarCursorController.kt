package com.beniezsche.bikiboard.spacebarcursor

import android.content.Context
import android.graphics.Rect
import android.view.GestureDetector
import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import kotlin.math.abs

class SpacebarCursorController(private val context: Context, private val targetKeyBox: Rect,  private val cursorMovementListener: CursorMovementListener) {

    private var isCursorDragModeActive : Boolean = false
    private var isSpaceBarHit : Boolean = false

    companion object {
        private const val SWIPE_DRAG_CURSOR_THRESHOLD = 35
    }

    private var initialX = 0
    private var initialY = 0



    private val gestureDetector = GestureDetector(context, object : OnGestureListener {
        override fun onDown(p0: MotionEvent): Boolean {
            return false
        }

        override fun onShowPress(p0: MotionEvent) {
        }

        override fun onSingleTapUp(p0: MotionEvent): Boolean {
            return false

        }

        override fun onScroll(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
            return false

        }

        override fun onLongPress(p0: MotionEvent) {
            if (isSpaceBarHit) {
                isCursorDragModeActive = true
                cursorMovementListener.spacebarCursorStarted()
            }
        }

        override fun onFling(p0: MotionEvent?, p1: MotionEvent, p2: Float, p3: Float): Boolean {
            return false
        }
    })

    fun onTouchEvent(motionEvent: MotionEvent) {

        gestureDetector.onTouchEvent(motionEvent)

        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> {
                initialX = motionEvent.x.toInt()
                initialY = motionEvent.y.toInt()

                if (targetKeyBox.contains(initialX, initialY))
                    isSpaceBarHit = true

            }

            MotionEvent.ACTION_MOVE -> {

                val currentX = motionEvent.x.toInt()
                val currentY = motionEvent.y.toInt()

                val delX = abs(currentX - initialX)
                val delY = abs(currentY - initialY)

                if (!isCursorDragModeActive)
                    return

                if (delY < SWIPE_DRAG_CURSOR_THRESHOLD && delX < SWIPE_DRAG_CURSOR_THRESHOLD)
                    return

                if (delY > delX) { // moving up or down
                    if (currentY > initialY ) { // moving down
                        cursorMovementListener.moveDown()
                    } else { //moving up
                        cursorMovementListener.moveUp()
                    }
                } else if (delX > delY) { // moving left or right
                    if (currentX > initialX) { // moving right
                        cursorMovementListener.moveRight()
                    } else { // moving left
                        cursorMovementListener.moveLeft()
                    }
                }

                setNewOriginPoint(currentX, currentY)
            }

            MotionEvent.ACTION_UP -> {

                setNewOriginPoint(0,0)

                if (isSpaceBarHit)
                    isSpaceBarHit = false

                if (isCursorDragModeActive) {
                    isCursorDragModeActive = false
                    cursorMovementListener.spacebarCursorEnded()
                }
            }
        }
    }


    private fun setNewOriginPoint(x: Int, y: Int) {
        initialX = x
        initialY = y
    }

    interface CursorMovementListener {

        fun spacebarCursorStarted()

        fun moveUp()
        fun moveDown()
        fun moveLeft()
        fun moveRight()

        fun spacebarCursorEnded()
    }

}